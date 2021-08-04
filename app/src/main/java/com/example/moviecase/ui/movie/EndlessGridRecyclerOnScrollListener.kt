package com.example.moviecase.ui.movie

import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

abstract class EndlessGridRecyclerOnScrollListener(private val gridLayoutManager: GridLayoutManager) :
    RecyclerView.OnScrollListener() {
    // The total number of items in the dataset after the last load
    private var previousTotal = 0

    // True if we are still waiting for the last set of data to load.
    private var loading = true
    abstract fun onLoadMore()
    override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
        super.onScrolled(recyclerView, dx, dy)
        val visibleItemCount = gridLayoutManager.childCount
        val totalItemCount = gridLayoutManager.itemCount
        val firstVisibleItem = gridLayoutManager.findFirstVisibleItemPosition()
        if (loading) {
            if (totalItemCount > previousTotal) {
                loading = false
                previousTotal = totalItemCount
            }
        }
        if (!loading && totalItemCount - visibleItemCount <= firstVisibleItem + VISIBLE_THRESHOLD) {
            onLoadMore()
            loading = true
        }
    }

    fun reset() {
        previousTotal = 0
    }

    companion object {
        //default item_love_it_leave_it count to request from server
        const val DEFAULT_LIMIT = 20

        // The minimum amount of items to have below your current scroll position before loading more.
        private const val VISIBLE_THRESHOLD = 0
    }

}