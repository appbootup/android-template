package org.jdc.template.ui.menu;

import android.app.Activity;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.view.MenuItem;

import org.jdc.template.InternalIntents;
import org.jdc.template.R;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class DrawerMenu {
    private final InternalIntents internalIntents;

    private Activity parentActivity;

    @Inject
    public DrawerMenu(InternalIntents internalIntents) {
        this.internalIntents = internalIntents;
    }

    public void setupDrawerMenu(Activity parentActivity, final DrawerLayout drawerLayout, NavigationView navigationView) {
        this.parentActivity = parentActivity;

        navigationView.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(MenuItem menuItem) {
                        menuItem.setChecked(true);
                        onDrawerItemSelected(menuItem);
                        drawerLayout.closeDrawers();
                        return true;
                    }
                });
    }

    private boolean onDrawerItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_drawer_item_settings:
                internalIntents.showSettings(parentActivity);
                return true;
            case R.id.menu_drawer_item_help:
                internalIntents.showHelp(parentActivity);
                return true;
        }

        return false;
    }
}
