package org.codeandmagic.android;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBarActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;

public class MainActivity extends ActionBarActivity {

    public static final String THEME_ID = "theme_id";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // The AppTheme.Light theme shows Roboto and SourceSansPro fonts.
        // The AppTheme.Dark  theme shows SourceSansPro font.
        final int themeId;
        if (getIntent().hasExtra(THEME_ID)) {
            themeId = getIntent().getIntExtra(THEME_ID, R.style.AppTheme_Light);
            setTheme(themeId);
        } else {
            themeId = MyApp.getThemeId(this);
        }

        setContentView(R.layout.activity_main);

        // Demo fragments for showing the fonts in action.
        if (savedInstanceState == null) {
            final Fragment fragment = (R.style.AppTheme_Light == themeId) ? RobotoFragment.newInstance()
                    : SourceSansProFragment.newInstance();
            getSupportFragmentManager().beginTransaction().add(R.id.container, fragment).commit();
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return item.getItemId() == R.id.action_settings || super.onOptionsItemSelected(item);
    }

    public void switchTheme() {
        final int themeId;
        if (getIntent().hasExtra(THEME_ID)) {
            themeId = getIntent().getIntExtra(THEME_ID, R.style.AppTheme_Light);
        } else {
            themeId = MyApp.getThemeId(this);
        }
        final int newThemeId = (R.style.AppTheme_Light == themeId) ? R.style.AppTheme_Dark : R.style.AppTheme_Light;
        finish();
        startActivity(getIntent().putExtra(THEME_ID, newThemeId));
    }


    public static class RobotoFragment extends Fragment {

        public static RobotoFragment newInstance() {
            return new RobotoFragment();
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            final View rootView = inflater.inflate(R.layout.fragment_main_roboto, container, false);

            // Apply a custom TextStyle from code.
            final TypefaceTextView textView = (TypefaceTextView) rootView.findViewById(R.id.textView);
            textView.setTextStyle(RobotoTextStyle.BOLD);

            rootView.findViewById(R.id.switch_theme).setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View v) {
                    ((MainActivity) getActivity()).switchTheme();
                }
            });
            return rootView;
        }
    }

    public static class SourceSansProFragment extends Fragment {

        public static SourceSansProFragment newInstance() {
            return new SourceSansProFragment();
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            final View rootView = inflater.inflate(R.layout.fragment_main_source, container, false);

            rootView.findViewById(R.id.switch_theme).setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View v) {
                    ((MainActivity) getActivity()).switchTheme();
                }
            });
            return rootView;
        }
    }

}
