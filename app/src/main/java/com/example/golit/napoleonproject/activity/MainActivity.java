package com.example.golit.napoleonproject.activity;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import com.example.golit.napoleonproject.R;
import com.example.golit.napoleonproject.bins.ActionRes;
import com.example.golit.napoleonproject.bins.DataRes;
import com.example.golit.napoleonproject.bins.GetBinsFromSite;
import com.example.golit.napoleonproject.utils.ConstantManager;
import com.example.golit.napoleonproject.utils.NetworkUtils;
import com.example.golit.napoleonproject.utils.PicassoCache;
import com.squareup.picasso.OkHttpDownloader;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    static final String TAG = ConstantManager.TAG_PREFIX + "ScrollingActivity";
    private List<DataRes> dataFromSite;
    private List<ActionRes> actionFromSite;
    @BindView(R.id.drawer_layout)
    DrawerLayout drawer;
    @BindView(R.id.nav_view)
    NavigationView navigationView;
    @BindView(R.id.products_text_view)
    TextView productsTextView;
    @BindView(R.id.top10_text_view)
    TextView top10TextView;
    @BindView(R.id.shops_text_view)
    TextView shopsTextView;
    @BindView(R.id.search_edit_text)
    EditText searchEditText;
    @BindView(R.id.service_image_view)
    ImageView serviceImageView;
    @BindView(R.id.scroll_view)
    ScrollView scrollView;
    @BindView(R.id.linear_lay_scroll_view)
    LinearLayout llScroll;
    @BindView(R.id.linear_lay_horiz_scroll_view)
    LinearLayout horizllScrol;
    @BindView(R.id.horiz_scroll_view)
    HorizontalScrollView horizontalScrollView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d(TAG, "onCreate");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        navigationView.setNavigationItemSelectedListener(this);
        if (savedInstanceState == null) {

            /*Picasso.Builder builder = new Picasso.Builder(this);
            builder.downloader(new OkHttpDownloader(this, Integer.MAX_VALUE));
            Picasso built = builder.build();
            built.setIndicatorsEnabled(false);
            built.setLoggingEnabled(false);
            Picasso.setSingletonInstance(built);*/

            getData();
        } else {
            dataFromSite = savedInstanceState.getParcelableArrayList(ConstantManager.LIST_DATA);
            actionFromSite = savedInstanceState.getParcelableArrayList(ConstantManager.LIST_ACTION);
            inflateAction();
            inflateData();
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.d(TAG, "onSaveInstanceState");
        outState.putParcelableArrayList(ConstantManager.LIST_DATA, (ArrayList<? extends Parcelable>) dataFromSite);
        outState.putParcelableArrayList(ConstantManager.LIST_ACTION, (ArrayList<? extends Parcelable>) actionFromSite);
    }

    @Override
    public void onBackPressed() {
        Log.d(TAG, "onBackPressed");
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        Log.d(TAG, "onNavigationItemSelected");
        return false;
    }

    @OnClick(R.id.top10_text_view)
    public void onClickTop10() {
        Log.d(TAG, "onClickTop10");
            top10TextView.setBackgroundResource(R.drawable.rectangle_rounded_dark);
            shopsTextView.setBackgroundResource(0);
            productsTextView.setBackgroundResource(0);
    }

    @OnClick(R.id.shops_text_view)
    public void onClickShops() {
        Log.d(TAG, "onClickShops");
            shopsTextView.setBackgroundResource(R.drawable.rectangle_rounded_dark);
            top10TextView.setBackgroundResource(0);
            productsTextView.setBackgroundResource(0);
    }

    @OnClick(R.id.products_text_view)
    public void onClickProducts() {
        Log.d(TAG, "onClickProducts");
            productsTextView.setBackgroundResource(R.drawable.rectangle_rounded_dark);
            shopsTextView.setBackgroundResource(0);
            top10TextView.setBackgroundResource(0);
    }

    @OnClick(R.id.service_image_view)
    public void onClickServiceImageView() {
        Log.d(TAG, "onClickServiceImageView");
        drawer.openDrawer(Gravity.START);
    }

    private void getData() {
        Log.d(TAG, "getData");

        if (NetworkUtils.isNetworkAvailable(this)) {
            Retrofit retrofit = new Retrofit.Builder().baseUrl(ConstantManager.DATA_GET).addConverterFactory(GsonConverterFactory.create()).build();
            GetBinsFromSite service = retrofit.create(GetBinsFromSite.class);
            service.getActionResList().enqueue(new Callback<List<ActionRes>>() {
                @Override
                public void onResponse(Call<List<ActionRes>> call, Response<List<ActionRes>> response) {
                    if (response.code() == 200) {
                        actionFromSite = response.body();
                        inflateAction();
                    }
                }

                @Override
                public void onFailure(Call<List<ActionRes>> call, Throwable t) {
                }
            });
            service.getDataResList().enqueue(new Callback<List<DataRes>>() {
                @Override
                public void onResponse(Call<List<DataRes>> call, Response<List<DataRes>> response) {
                    if (response.code() == 200) {
                        dataFromSite = response.body();
                        inflateData();
                    }
                }

                @Override
                public void onFailure(Call<List<DataRes>> call, Throwable t) {
                }
            });
        }
    }

    private void inflateData() {
        Log.d(TAG, "inflateData");
        Collections.sort(dataFromSite, new Comparator<DataRes>() {
            @Override
            public int compare(DataRes o1, DataRes o2) {
                int rezult = 0;
                if (o1.getType() > o2.getType()) rezult = 1;
                if (o1.getType() < o2.getType()) rezult = -1;
                return rezult;
            }
        });
        int cardType = 0;
        for (DataRes data : dataFromSite) {
            int type = data.getType();
            LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            if (cardType != type) {
                cardType = type;
                View view = inflater.inflate(R.layout.card_droup, null);
                llScroll.addView(view);
                TextView group = (TextView) view.findViewById(R.id.card_group_text);
                group.setText(type == 1 ? getString(R.string.text_actions) : getString(R.string.text_sell));
            }
            String name = data.getName();
            String descr = data.getDescr();
            String group = data.getGroup();
            float discount = Float.parseFloat(data.getDiscount());
            String price = data.getPrice();
            String urlThumbImage = data.getUrlThumbImage();
            View view = inflater.inflate(R.layout.card_view, null);
            llScroll.addView(view);
            ImageView image = (ImageView) view.findViewById(R.id.card_image);
            TextView textName = (TextView) view.findViewById(R.id.card_name);
            TextView textMiddleLine = (TextView) view.findViewById(R.id.card_middle_line);
            TextView textPercentage = (TextView) view.findViewById(R.id.card_percentage);
            TextView textPrice = (TextView) view.findViewById(R.id.card_price);
            TextView textPriceSeller = (TextView) view.findViewById(R.id.card_price_seller);
            PicassoCache.getPicassoInstance(this).load(urlThumbImage).centerCrop().fit().into(image);
            textName.setText(name);
            textMiddleLine.setText(type == 1 ? descr : group);
            float pr = Float.parseFloat(price);
            float priceSeller = pr - discount;
            textPrice.setText(price);
            textPriceSeller.setText(String.valueOf(priceSeller));
            int percent = (int) (priceSeller / pr * 100);
            if (percent < Integer.MAX_VALUE) {
                textPercentage.setText("-" + String.valueOf(percent) + "%");
                textPercentage.setBackgroundResource(R.drawable.rectangle_rounded_red);
            }
        }
    }

    private void inflateAction() {
        Log.d(TAG, "inflateAction");
        for (ActionRes actionRes : actionFromSite) {
            LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View view = inflater.inflate(R.layout.horizontal_card, null);
            horizllScrol.addView(view);
            System.out.println("addd=" + view.getId());
            ImageView image = (ImageView) view.findViewById(R.id.horizontal_card_image);
            TextView textHorizCardLineOne = (TextView) view.findViewById(R.id.horizontal_card_lineOne);
            TextView textHorizCardLineTwo = (TextView) view.findViewById(R.id.horizontal_card_lineTwo);
            PicassoCache.getPicassoInstance(this).load(actionRes.getUrlThumbImage()).centerCrop().fit().into(image);
            textHorizCardLineOne.setText(actionRes.getLineOne());
            textHorizCardLineTwo.setText(actionRes.getLineTwo());
        }
        horizontalScrollView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_UP) {
                    float currentPosition = horizontalScrollView.getScrollX();
                    float pagesCount = horizllScrol.getChildCount();
                    float pageLengthInPx = horizllScrol.getMeasuredWidth() / pagesCount;
                    float currentPage = currentPosition / pageLengthInPx;

                    Boolean isBehindHalfScreen = currentPage - (int) currentPage > 0.5;

                    float edgePosition = 0;
                    if (isBehindHalfScreen) {
                        edgePosition = (int) (currentPage + 1) * pageLengthInPx;
                    } else {
                        edgePosition = (int) currentPage * pageLengthInPx;
                    }

                    horizontalScrollView.scrollTo((int) edgePosition, 0);
                }

                return false;
            }
        });
    }

}
