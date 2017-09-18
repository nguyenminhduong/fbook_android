package com.framgia.fbook.screen.bookdetail

import android.content.Context
import android.databinding.DataBindingUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.framgia.fbook.R
import com.framgia.fbook.data.model.Owner
import com.framgia.fbook.databinding.ItemListUserBinding
import com.framgia.fbook.screen.BaseRecyclerViewAdapter

/**
 * Created by framgia on 15/09/2017.
 */
class OwnerAdapter constructor(
    context: Context) : BaseRecyclerViewAdapter<OwnerAdapter.ItemViewHolder>(context) {

  private val mOwners = arrayListOf<Owner>()
  private lateinit var mItemOwnerClickListener: ItemOwnerClickListener
  fun updateData(listOwner: List<Owner>?) {
    mOwners.clear()
    listOwner?.let { mOwners.addAll(it) }
    notifyDataSetChanged()
  }

  fun setItemUserClickListener(itemOwnerClickListener: ItemOwnerClickListener) {
    mItemOwnerClickListener = itemOwnerClickListener
  }

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
    val binding = DataBindingUtil.inflate<ItemListUserBinding>(
        LayoutInflater.from(parent.context),
        R.layout.item_list_user, parent, false)
    return ItemViewHolder(binding, mItemOwnerClickListener)
  }

  override fun onBindViewHolder(holder: OwnerAdapter.ItemViewHolder, position: Int) {
    holder.bind(mOwners[position])
  }

  override fun getItemCount(): Int {
    return mOwners.size
  }

  class ItemViewHolder(private val mBinding: ItemListUserBinding,
      private val mItemOwnerClickListener: ItemOwnerClickListener?) : RecyclerView.ViewHolder(
      mBinding.root) {

    fun bind(owner: Owner) {
      mBinding.viewModel = ItemOwnerViewModel(owner, mItemOwnerClickListener)
      mBinding.executePendingBindings()
    }
  }
}
