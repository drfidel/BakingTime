package com.example.ab.bakingtime.activity.recipe_step_list.recipe_step_detail;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import com.example.ab.bakingtime.R;
import com.example.ab.bakingtime.activity.recipe_step_list.RecipeStepListActivity;

public class RecipeStepDetailActivity extends AppCompatActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_recipe_step_detail);
    Toolbar toolbar = (Toolbar) findViewById(R.id.detail_toolbar);
    setSupportActionBar(toolbar);

    ActionBar actionBar = getSupportActionBar();
    if (actionBar != null) {
      actionBar.setDisplayHomeAsUpEnabled(true);
    }

    // savedInstanceState is non-null when there is fragment state
    // saved from previous configurations of this activity
    // (e.g. when rotating the screen from portrait to landscape).
    // In this case, the fragment will automatically be re-added
    // to its container so we don't need to manually add it.
    // For more information, see the Fragments API guide at:
    //
    // http://developer.android.com/guide/components/fragments.html
    //
    if (savedInstanceState == null) {
      Bundle arguments = new Bundle();
      arguments.putInt(RecipeStepDetailFragment.ARG_RECIPE_ID_KEY,
          getIntent().getIntExtra(RecipeStepDetailFragment.ARG_RECIPE_ID_KEY, -1));
      arguments.putInt(RecipeStepDetailFragment.ARG_RECIPE_STEP_ID_KEY,
          getIntent().getIntExtra(RecipeStepDetailFragment.ARG_RECIPE_STEP_ID_KEY, -1));
      arguments.putBoolean(RecipeStepDetailFragment.ARG_IS_FOR_INGREDIENT,
          getIntent().getBooleanExtra(RecipeStepDetailFragment.ARG_IS_FOR_INGREDIENT, false));
      RecipeStepDetailFragment fragment = new RecipeStepDetailFragment();
      fragment.setArguments(arguments);
      getSupportFragmentManager().beginTransaction()
          .add(R.id.frame_layout_recipe_step_detail_container, fragment)
          .commit();
    }
  }

  @Override
  public boolean onOptionsItemSelected(MenuItem item) {
    int id = item.getItemId();
    if (id == android.R.id.home) {
      // This ID represents the Home or Up button. In the case of this
      // activity, the Up button is shown. For
      // more details, see the Navigation pattern on Android Design:
      //
      // http://developer.android.com/design/patterns/navigation.html#up-vs-back
      //
      navigateUpTo(new Intent(this, RecipeStepListActivity.class));
      return true;
    }
    return super.onOptionsItemSelected(item);
  }
}
