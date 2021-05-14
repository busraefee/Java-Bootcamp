package Adapters;

import java.rmi.RemoteException;

import Abstract.CustomerCheckService;
import Entities.Customer;
import tr.gov.nvi.tckimlik.WS.KPSPublicSoapProxy;
import tr.gov.nvi.tckimlik.WS.KPSPublicSoap;



public class MernisServiceAdapter implements CustomerCheckService{

	
	private boolean result;
	@Override
	public boolean CheckIfRealPerson(Customer customer) {
		
		
		KPSPublicSoap client = new KPSPublicSoapProxy();
		this.result = false;
		try {
			this.result = client.TCKimlikNoDogrula(Long.parseLong(customer.getNationalityId()),
					customer.getFirstName().toUpperCase(),customer.getLastName().toUpperCase(),
					customer.getDateOfBirth().getYear());
			
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return this.result;

		//client.TCKimlikNoDogrula(Long.parseLong(customer.getNationaltyId()), customer.getFirstName().toUpperCase(), customer.getLastName().toUpperCase(), customer.getDateOfBirth().getYear());
	}

}
