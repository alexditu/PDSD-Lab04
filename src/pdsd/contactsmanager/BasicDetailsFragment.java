package pdsd.contactsmanager;

import android.R.layout;
import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.view.View.OnClickListener;

public class BasicDetailsFragment extends Fragment {

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		
		Activity activity = getActivity();
		ButtonActions clickListener = new ButtonActions(activity);
		
		Button btnSave 			= (Button) activity.findViewById(R.id.btnSave);
		Button btnCancel 		= (Button) activity.findViewById(R.id.btnCancel);
		Button btnShowFields 	= (Button) activity.findViewById(R.id.btnShowFields);
		
		btnSave.setOnClickListener(clickListener);
		btnCancel.setOnClickListener(clickListener);
		btnShowFields.setOnClickListener(clickListener);
	}
	
	@Override
	public View onCreateView(LayoutInflater layoutInflater, ViewGroup container, Bundle state) {
		return layoutInflater.inflate(R.layout.fragment_basic_details, container, false);
	}
}
