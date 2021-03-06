package com.example.userprofile

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import kotlinx.android.synthetic.main.activity_profile.*

class ProfileActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)
        InitViews()
    }

    private fun InitViews() {
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = "This is your profile!"

        val profile = intent.getParcelableExtra<Profile>(PROFILE_EXTRA)

        if (profile != null) {
            tvName.text = getString(R.string.name, profile.firstName, profile.lastName)
            tvDesc.text = profile.description
            if (profile.imageUri != null) ivProfileImg.setImageURI(profile.imageUri)
        }
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        return when (item?.itemId) {
            android.R.id.home -> {
                finish()
                true
            }
            else -> return super.onOptionsItemSelected(item)
        }
    }

    companion object {
        const val PROFILE_EXTRA = "PROFILE_EXTRA"
    }
}
