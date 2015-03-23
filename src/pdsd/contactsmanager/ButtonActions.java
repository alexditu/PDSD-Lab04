package pdsd.contactsmanager;

import java.util.ArrayList;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.ContentValues;
import android.content.Intent;
import android.provider.ContactsContract;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class ButtonActions implements OnClickListener {
	public Activity activity;

	public ButtonActions(Activity activity) {
		this.activity = activity;
	}

	@Override
	public void onClick(View v) {
		
		switch (v.getId()) {
		
		case R.id.btnSave:
			EditText name 	= ((EditText) activity.findViewById(R.id.etName));
			EditText phone 	= ((EditText) activity.findViewById(R.id.etPhone));
			EditText email 	= ((EditText) activity.findViewById(R.id.etEmail));
			EditText address 	= ((EditText) activity.findViewById(R.id.etAddress));
			EditText jobTitle = ((EditText) activity.findViewById(R.id.etJob));
			EditText company 	= ((EditText) activity.findViewById(R.id.etCompany));
			EditText website 	= ((EditText) activity.findViewById(R.id.etWebsite));
			EditText im 	= ((EditText) activity.findViewById(R.id.etIM));
			
			Intent intent = new Intent(ContactsContract.Intents.Insert.ACTION);
			intent.setType(ContactsContract.RawContacts.CONTENT_TYPE);
			if (name != null) {
			  intent.putExtra(ContactsContract.Intents.Insert.NAME, name.getText().toString());
			}
			if (phone != null) {
			  intent.putExtra(ContactsContract.Intents.Insert.PHONE, phone.getText().toString());
			}
			if (email != null) {
			  intent.putExtra(ContactsContract.Intents.Insert.EMAIL, email.getText().toString());
			}
			if (address != null) {
			  intent.putExtra(ContactsContract.Intents.Insert.POSTAL, address.getText().toString());
			}
			if (jobTitle != null) {
			  intent.putExtra(ContactsContract.Intents.Insert.JOB_TITLE, jobTitle.getText().toString());
			}
			if (company != null) {
			  intent.putExtra(ContactsContract.Intents.Insert.COMPANY, company.getText().toString());
			}
			
			ArrayList<ContentValues> contactData = new ArrayList<ContentValues>();
			if (website != null) {
			  ContentValues websiteRow = new ContentValues();
			  websiteRow.put(ContactsContract.Data.MIMETYPE, ContactsContract.CommonDataKinds.Website.CONTENT_ITEM_TYPE);
			  websiteRow.put(ContactsContract.CommonDataKinds.Website.URL, website.getText().toString());
			  contactData.add(websiteRow);
			}
			if (im != null) {
			  ContentValues imRow = new ContentValues();
			  imRow.put(ContactsContract.Data.MIMETYPE, ContactsContract.CommonDataKinds.Im.CONTENT_ITEM_TYPE);
			  imRow.put(ContactsContract.CommonDataKinds.Im.DATA, im.getText().toString());
			  contactData.add(imRow);
			}
			intent.putParcelableArrayListExtra(ContactsContract.Intents.Insert.DATA, contactData);
			activity.startActivity(intent);
			break;

		case R.id.btnCancel:
			activity.finish();
			break;

		case R.id.btnShowFields:
			FragmentManager fragmentManager = activity.getFragmentManager();
			FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

			AdditionalDetailsFragment additionalDetailsFragment = (AdditionalDetailsFragment) fragmentManager.findFragmentById(R.id.containerBottom);
			if (additionalDetailsFragment == null) {
				fragmentTransaction.add(R.id.containerBottom,new AdditionalDetailsFragment());
				((Button) v).setText(activity.getResources().getString(R.string.hide_additional_fields));
				fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_ENTER_MASK);
			} else {
				fragmentTransaction.remove(additionalDetailsFragment);
				((Button) v).setText(activity.getResources().getString(R.string.show_additional_fields));
				fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_EXIT_MASK);
			}
			
			fragmentTransaction.commit();
			break;
		}
	}

}
