package com.example.dcow.djagal;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v7.preference.Preference;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.support.v7.preference.PreferenceFragmentCompat;
import android.widget.Toast;

/**
 * A simple {@link Fragment} subclass.
 */
public class SettingsFragment extends PreferenceFragmentCompat {
    private OnFragmentInteractionListener mListener;

    public SettingsFragment() {
        // Required empty public constructor
    }

    public interface OnFragmentInteractionListener {}

    @Override
    public void onCreatePreferences(Bundle savedInstanceState,
                                    String rootKey) {
        setPreferencesFromResource(R.xml.preferences, rootKey);
        Preference locateMe = (Preference) findPreference("locate_me_preference");
        locateMe.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() {
            @Override
            public boolean onPreferenceClick(Preference preference) {
                LocationManager locationManager = (LocationManager) getActivity().getSystemService(Context.LOCATION_SERVICE);

                // Define a listener that responds to location updates
                LocationListener locationListener = new LocationListener() {
                    public void onLocationChanged(Location location) {
                        String str = "Latitude: "+location.getLatitude()+"Longitude: " +location.getLongitude();
                        Toast.makeText(getActivity().getBaseContext(), str, Toast.LENGTH_LONG).show();
                    }

                    public void onStatusChanged(String provider, int status, Bundle extras) {
                    }

                    public void onProviderEnabled(String provider) {
                        Toast.makeText(getActivity().getBaseContext(), "Gps turned off ", Toast.LENGTH_LONG).show();
                    }

                    public void onProviderDisabled(String provider) {
                        Toast.makeText(getActivity().getBaseContext(), "Gps turned on ", Toast.LENGTH_LONG).show();
                    }
                };

                // Register the listener with the Location Manager to receive location updates
                if (ActivityCompat.checkSelfPermission(
                        getActivity(), Manifest.permission.ACCESS_FINE_LOCATION) !=
                        PackageManager.PERMISSION_GRANTED &&
                        ActivityCompat.checkSelfPermission (
                                getActivity(), Manifest.permission.ACCESS_COARSE_LOCATION)
                                != PackageManager.PERMISSION_GRANTED) {
                    return true;
                }
                locationManager.requestLocationUpdates(
                        LocationManager.NETWORK_PROVIDER, 0, 0, locationListener);
                Toast.makeText(getActivity().getBaseContext(), "Gps", Toast.LENGTH_LONG).show();
                return false;
            }
        });

        Preference signOut = (Preference) findPreference("signout_preference");
        signOut.setOnPreferenceClickListener (new Preference.OnPreferenceClickListener() {
            @Override
            public boolean onPreferenceClick(Preference preference) {
                ((MainActivity)getActivity()).signOut();
                return false;
            }
        });
    }

}
