package com.windowsazure.samples.android.sampleapp;

import com.windowsazure.samples.android.storageclient.CloudBlobClient;
import com.windowsazure.samples.android.storageclient.CloudClientAccount;
import com.windowsazure.samples.android.storageclient.CloudQueueClient;
import com.windowsazure.samples.android.storageclient.CloudTableClient;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Application;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;

public class SampleApplication extends Application {

	private CloudBlobClient m_CloudBlobClient;
	private CloudClientAccount m_CloudClientAccount;
	private CloudQueueClient m_CloudQueueClient;
	private CloudTableClient m_CloudTableClient;

    public CloudBlobClient getCloudBlobClient() throws Exception {
        if (m_CloudBlobClient == null)
        {
        	m_CloudBlobClient = this.getCloudClientAccount().createCloudBlobClient();
        }
        return m_CloudBlobClient;
    }
    public CloudQueueClient getCloudQueueClient() throws Exception {
        if (m_CloudQueueClient == null)
        {
        	m_CloudQueueClient = this.getCloudClientAccount().createCloudQueueClient();
        }
        return m_CloudQueueClient;
    }
    public CloudTableClient getCloudTableClient() throws Exception {
        if (m_CloudTableClient == null)
        {
        	m_CloudTableClient = this.getCloudClientAccount().createCloudTableClient();
        }
        return m_CloudTableClient;
    }

    public void setCloudClientAccount(CloudClientAccount cloudClientAccount) {
		m_CloudClientAccount = cloudClientAccount;
	}
	
	public CloudClientAccount getCloudClientAccount() throws Exception {
		if (m_CloudClientAccount == null)
		{
			throw new Exception("You need to set a Cloud Client Account before being able to access it.");
		}
		return m_CloudClientAccount;
	}

	void showErrorMessage(Exception exception)
	{
		exception.printStackTrace();
    	System.out.println(exception.toString());
		AlertDialog.Builder builder = new AlertDialog.Builder(this);
		builder.setTitle(getString(R.string.configuration_error_title));
		builder.setMessage(exception.getLocalizedMessage());
		builder.setCancelable(true);

		AlertDialog dialog = builder.create();
		dialog.setCanceledOnTouchOutside(true);
		dialog.show();
	}
}
