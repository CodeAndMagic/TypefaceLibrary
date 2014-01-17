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

        if (getIntent().hasExtra(THEME_ID)) {
            setTheme(getIntent().getIntExtra(THEME_ID, R.style.AppTheme_Light));
        }

        setContentView(R.layout.activity_main);

        // Demo fragments for showing the fonts in action.
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().add(R.id.container, MainFragment.newInstance()).commit();
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


    public static class MainFragment extends Fragment {

        public static MainFragment newInstance() {
            return new MainFragment();
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            final View view = inflater.inflate(R.layout.fragment_main, container, false);

            // Apply a custom TextStyle from code.
            final TypefaceTextView textView = (TypefaceTextView) view.findViewById(R.id.textView);
            textView.setTextStyle(RobotoTextStyle.BOLD);

            view.findViewById(R.id.switch_theme).setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View v) {
                    ((MainActivity) getActivity()).switchTheme();
                }
            });
            return view;
        }
    }
}
