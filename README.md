# SwipeRefreshLayoutExample

```xml
<?xml version="1.0" encoding="utf-8"?>
<androidx.constraintlayout.widget.ConstraintLayout
    ...>

    <androidx.swiperefreshlayout.widget.SwipeRefreshLayout
        android:id="@+id/swipeRefreshLayout"
        ...
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toTopOf="parent">

        <LinearLayout
            android:layout_width="match_parent"
            android:layout_height="match_parent"
            android:gravity="center"
            android:orientation="vertical">

            <TextView
                android:text="0"
                android:id="@+id/tv"
                android:layout_width="wrap_content"
                android:layout_height="wrap_content" />
        </LinearLayout>
    </androidx.swiperefreshlayout.widget.SwipeRefreshLayout>
</androidx.constraintlayout.widget.ConstraintLayout>
```

```java
private SwipeRefreshLayout swipeRefreshLayout;
private TextView textView;

private void initView() {
    swipeRefreshLayout = findViewById(R.id.swipeRefreshLayout);
    textView = findViewById(R.id.tv);

    swipeRefreshLayout.setOnRefreshListener(() -> {
        swipeRefreshLayout.setRefreshing(true);

        new Handler().postDelayed(() -> {
            Random r = new Random();
            int randomNumber = r.nextInt(100);
            textView.setText(randomNumber+"");
            swipeRefreshLayout.setRefreshing(false);
        }, 1000);
    });
}
```

---

```
Copyright 2022 M. Fadli Zein
```