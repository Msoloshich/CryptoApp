package com.example.cryptoapp.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.cryptoapp.R
import com.example.cryptoapp.databinding.ItemCoinInfoBinding
import com.example.cryptoapp.pojo.CoinPriceInfo
import com.squareup.picasso.Picasso


class CoinInfoAdapter(private val context: Context) : RecyclerView.Adapter<CoinInfoAdapter.CoinInfoViewHolder>() {
    var coinInfoList: List<CoinPriceInfo> = listOf()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    var onCoinClickListener: OnCoinClickListener? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CoinInfoViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(
            R.layout.item_coin_info, parent, false
        )
        return CoinInfoViewHolder(view)
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: CoinInfoViewHolder, position: Int) {
        val coin = coinInfoList[position]
        with(holder) {
            with(coin) {
                with(binding) {
                    val symbolsTemplate = context.resources.getString(R.string.symbols_template)
                    val lastUpdateTime = context.resources.getString(R.string.last_update_time)
                    tvSymbols.text = String.format(symbolsTemplate, fromSymbol, toSymbol)
                    tvPrice.text = price
                    tvLastUpdate.text =
                        String.format(lastUpdateTime, coin.getFormattedTime())
                    Picasso.get().load(getFullImageUrl()).into(ivLogoCoin)
                }
            }
        }
        holder.itemView.setOnClickListener{
            onCoinClickListener?.onCoinClick(coin)
        }
    }

    override fun getItemCount() = coinInfoList.size

    inner class CoinInfoViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val binding = ItemCoinInfoBinding.bind(itemView);
    }

    interface OnCoinClickListener {
        fun onCoinClick(coinPriceInfo: CoinPriceInfo)
    }
}
