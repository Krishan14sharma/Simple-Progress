Simple-Progress
===============

Custom Progress Dialog

 This is simple to show and hide progress wheel.One can provide loading drawable with the loading text.
 It will provide the rotate animation for a simple drawable and will simply animate the drawable in case of animation drawable.
 Hide and show the progress as required.


USAGE
=====
 <view.progress.LoadingProgress
     android:id="@+id/loading"
     android:layout_width="wrap_content"
     android:layout_height="wrap_content"
     android:layout_gravity="center"
     android:orientation="horizontal" 
     app1:loadingresource="@drawable/progress_drawable"
     app1:loadingtext="loading.."
     />
