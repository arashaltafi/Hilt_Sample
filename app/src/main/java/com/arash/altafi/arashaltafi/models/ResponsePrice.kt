package com.arash.altafi.arashaltafi.models

import com.google.gson.annotations.SerializedName
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

data class ResponsePrice (

	@field:SerializedName("sana")
	val sana: Sana
)

data class Sana (

	@field:SerializedName("per_page")
	val perPage: Int,

	@field:SerializedName("total")
	val total: Int,

	@field:SerializedName("data")
	val data: List<DataItem>,

	@field:SerializedName("last_page")
	val lastPage: Int,

	@field:SerializedName("next_page_url")
	val nextPageUrl: String,

	@field:SerializedName("from")
	val from: Int,

	@field:SerializedName("to")
	val to: Int,

	@field:SerializedName("prev_page_url")
	val prevPageUrl: Any,

	@field:SerializedName("current_page")
	val currentPage: Int
)

data class DataItem(

	@field:SerializedName("p")
	val P: Int,

	@field:SerializedName("dt")
	val dt: String,

	@field:SerializedName("d")
	val D: Int,

	@field:SerializedName("t")
	val T: String,

	@field:SerializedName("updated_at")
	val updatedAt: String,

	@field:SerializedName("h")
	val H: Int,

	@field:SerializedName("title")
	val title: String,

	@field:SerializedName("dp")
	val dp: Double,

	@field:SerializedName("l")
	val L: Int,

	@field:SerializedName("slug")
	val slug: String
)
