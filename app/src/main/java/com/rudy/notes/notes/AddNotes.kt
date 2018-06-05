package com.rudy.notes.notes

import android.content.ContentValues
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_add_notes.*

class AddNotes : AppCompatActivity() {

    var id = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_notes)

        try {
            var bundle:Bundle = intent.extras
            id = bundle.getInt("ID",0)
            if (id != 0) {
                etTitle.setText(bundle.getString("Name").toString())
                etDes.setText(bundle.getString("Description").toString())
            }
        }catch (ex:Exception)
        {

        }
    }

    fun buAdd(view: View)
    {

        var dbManag = dbManager(this)
        var values = ContentValues()
        values.put("Title", etTitle.text.toString())
        values.put("Description", etDes.text.toString())

        if (id == 0) {
            var ID = dbManag.Insert(values)
            if (ID > 0) {
                finish()
            } else {
                Toast.makeText(this, "Cannot add note", Toast.LENGTH_SHORT).show()
            }
        }
        else
        {
            var selectionArray = arrayOf(id.toString())
            var ID = dbManag.update(values,"ID=?",selectionArray)
            if (ID > 0) {
                finish()
            } else {
                Toast.makeText(this, "Cannot add note", Toast.LENGTH_SHORT).show()
            }

        }

    }
}
