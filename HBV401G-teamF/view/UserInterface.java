package view;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

import controllers.SearchEngine;

import org.eclipse.swt.widgets.List;
import org.eclipse.swt.widgets.DateTime;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import java.time.LocalDate;

public class UserInterface {

	protected Shell shlFlugLeitarvl;
	private DateTime departureDateSelector;
	private DateTime returnDateSelector;
	private Combo departureLocationCombo;
	private Combo returnLocationCombo;
	private Combo passangerQtySelector;
	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			UserInterface window = new UserInterface();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Open the window.
	 */
	public void open() {
		Display display = Display.getDefault();
		createContents();
		shlFlugLeitarvl.open();
		shlFlugLeitarvl.layout();
		while (!shlFlugLeitarvl.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}
	
	private void searchFlightData(){
		String departureDay = String.valueOf(departureDateSelector.getDay());
		String departureMonth = String.valueOf(departureDateSelector.getMonth()+1); //+1 since the Month count begins at 0
		String departureYear = String.valueOf(departureDateSelector.getYear());
		String departureDate = departureDay+"."+departureMonth+"."+departureYear;
		System.out.println("The departure date is: "+departureDate);		
		String returnDay = String.valueOf(returnDateSelector.getDay());
		String returnMonth = String.valueOf(returnDateSelector.getMonth()+1); //+1 since the Month count begins at 0
		String returnYear = String.valueOf(returnDateSelector.getYear());
		String returnDate = returnDay+"."+returnMonth+"."+returnYear;
		System.out.println("The return date is: "+returnDate);
		
		String departureLocation = departureLocationCombo.getText();
		String returnLocation = returnLocationCombo.getText();
		
		int passengerQty = Integer.valueOf(passangerQtySelector.getText());
		
		
		SearchEngine currentSearch = new SearchEngine();
		currentSearch.searchFlightByCriteria(departureDate, returnDate, departureLocation, returnLocation, passengerQty );
		
	}	
	
	
	private void createListView(){
		//TO DO!!!
	}
	
	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shlFlugLeitarvl = new Shell();
		shlFlugLeitarvl.setSize(1005, 730);
		shlFlugLeitarvl.setText("Search for flights!");
		
		
		
		List list = new List(shlFlugLeitarvl, SWT.BORDER);
		list.setBounds(0, 344, 979, 333);
		
		departureDateSelector = new DateTime(shlFlugLeitarvl, SWT.BORDER | SWT.CALENDAR);
		departureDateSelector.setBounds(20, 41, 233, 151);
		departureDateSelector.setDate(LocalDate.now().getDayOfMonth(), LocalDate.now().getMonthValue()-1, LocalDate.now().getYear());
		
		returnDateSelector = new DateTime(shlFlugLeitarvl, SWT.BORDER | SWT.CALENDAR);
		returnDateSelector.setBounds(608, 41, 233, 151);
		returnDateSelector.setDate(LocalDate.now().getDayOfMonth()+2, LocalDate.now().getMonthValue()-1, LocalDate.now().getYear());

		
		
		Label lblDepartureDate = new Label(shlFlugLeitarvl, SWT.NONE);
		lblDepartureDate.setBounds(20, 21, 88, 15);
		lblDepartureDate.setText("Departure date:");
		
		
		Label lblDepartureLocation = new Label(shlFlugLeitarvl, SWT.NONE);
		lblDepartureLocation.setText("Departure location:");
		lblDepartureLocation.setBounds(290, 21, 109, 15);
		
		Label lblReturnDate = new Label(shlFlugLeitarvl, SWT.NONE);
		lblReturnDate.setText("Return date:");
		lblReturnDate.setBounds(608, 21, 100, 15);
		
		Label lblReturnLocation = new Label(shlFlugLeitarvl, SWT.NONE);
		lblReturnLocation.setText("Return location:");
		lblReturnLocation.setBounds(854, 21, 100, 15);
		
		departureLocationCombo = new Combo(shlFlugLeitarvl, SWT.NONE);
		departureLocationCombo.setBounds(290, 41, 101, 177);
		
		returnLocationCombo = new Combo(shlFlugLeitarvl, SWT.NONE);
		returnLocationCombo.setBounds(864, 41, 91, 23);
		
		Button btnLeita = new Button(shlFlugLeitarvl, SWT.NONE);
		btnLeita.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				System.out.println("Nú ætti leit að hefjast");
				searchFlightData();
			}
		});
		
		btnLeita.setBounds(608, 198, 233, 90);
		btnLeita.setText("Search flights!");
		
		Group grpSur = new Group(shlFlugLeitarvl, SWT.NONE);
		grpSur.setText("Filters");
		grpSur.setBounds(20, 198, 233, 90);
		
		Button btnWifiAvaiable = new Button(grpSur, SWT.CHECK);
		btnWifiAvaiable.setBounds(10, 23, 93, 16);
		btnWifiAvaiable.setText("WiFi avaiable");
		
		Button btnMealsIncluded = new Button(grpSur, SWT.CHECK);
		btnMealsIncluded.setBounds(10, 45, 93, 16);
		btnMealsIncluded.setText("Meals included");
		
		Label lblPassangerQuantity = new Label(shlFlugLeitarvl, SWT.NONE);
		lblPassangerQuantity.setBounds(457, 21, 119, 15);
		lblPassangerQuantity.setText("Passenger quantity:");
		
		passenegerQtySelector = new Combo(shlFlugLeitarvl, SWT.NONE);
		passenegerQtySelector.setBounds(457, 41, 109, 23);

	}
}
