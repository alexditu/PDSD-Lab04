package pdsd.contactsmanager;

import android.R.layout;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class BasicDetailsFragment extends Fragment {

	FragmentManager fragmentManager = getFragmentManager();
	FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
	
	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		
	}
	
	@Override
	public View onCreateView(LayoutInflater lInflater, ViewGroup container, Bundle state) {
		return lInflater.inflate(R.layout.fragment_basic_details,  container, false);
	}
}
