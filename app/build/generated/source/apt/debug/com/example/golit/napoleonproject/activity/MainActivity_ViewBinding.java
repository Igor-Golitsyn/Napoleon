// Generated code from Butter Knife. Do not modify!
package com.example.golit.napoleonproject.activity;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.example.golit.napoleonproject.R;
import com.paging.listview.PagingListView;
import java.lang.IllegalStateException;
import java.lang.Override;

public class MainActivity_ViewBinding<T extends MainActivity> implements Unbinder {
  protected T target;

  private View view2131558522;

  private View view2131558520;

  private View view2131558521;

  private View view2131558518;

  @UiThread
  public MainActivity_ViewBinding(final T target, View source) {
    this.target = target;

    View view;
    target.drawer = Utils.findRequiredViewAsType(source, R.id.drawer_layout, "field 'drawer'", DrawerLayout.class);
    target.navigationView = Utils.findRequiredViewAsType(source, R.id.nav_view, "field 'navigationView'", NavigationView.class);
    view = Utils.findRequiredView(source, R.id.products_text_view, "field 'productsTextView' and method 'onClickProducts'");
    target.productsTextView = Utils.castView(view, R.id.products_text_view, "field 'productsTextView'", TextView.class);
    view2131558522 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClickProducts();
      }
    });
    view = Utils.findRequiredView(source, R.id.top10_text_view, "field 'top10TextView' and method 'onClickTop10'");
    target.top10TextView = Utils.castView(view, R.id.top10_text_view, "field 'top10TextView'", TextView.class);
    view2131558520 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClickTop10();
      }
    });
    view = Utils.findRequiredView(source, R.id.shops_text_view, "field 'shopsTextView' and method 'onClickShops'");
    target.shopsTextView = Utils.castView(view, R.id.shops_text_view, "field 'shopsTextView'", TextView.class);
    view2131558521 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClickShops();
      }
    });
    target.searchEditText = Utils.findRequiredViewAsType(source, R.id.search_edit_text, "field 'searchEditText'", EditText.class);
    view = Utils.findRequiredView(source, R.id.service_image_view, "field 'serviceImageView' and method 'onClickServiceImageView'");
    target.serviceImageView = Utils.castView(view, R.id.service_image_view, "field 'serviceImageView'", ImageView.class);
    view2131558518 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClickServiceImageView();
      }
    });
    target.scrollView = Utils.findRequiredViewAsType(source, R.id.scroll_view, "field 'scrollView'", ScrollView.class);
    target.llScroll = Utils.findRequiredViewAsType(source, R.id.linear_lay_scroll_view, "field 'llScroll'", LinearLayout.class);
    target.pagingListView = Utils.findRequiredViewAsType(source, R.id.paging_list_view, "field 'pagingListView'", PagingListView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    T target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");

    target.drawer = null;
    target.navigationView = null;
    target.productsTextView = null;
    target.top10TextView = null;
    target.shopsTextView = null;
    target.searchEditText = null;
    target.serviceImageView = null;
    target.scrollView = null;
    target.llScroll = null;
    target.pagingListView = null;

    view2131558522.setOnClickListener(null);
    view2131558522 = null;
    view2131558520.setOnClickListener(null);
    view2131558520 = null;
    view2131558521.setOnClickListener(null);
    view2131558521 = null;
    view2131558518.setOnClickListener(null);
    view2131558518 = null;

    this.target = null;
  }
}
