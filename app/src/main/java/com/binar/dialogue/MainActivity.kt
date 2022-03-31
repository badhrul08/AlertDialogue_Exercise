package com.binar.dialogue

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.binar.dialogue.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.showDialogueStandard.setOnClickListener {
            val dialogue = AlertDialog.Builder(this)
            dialogue.setTitle("Dialogue Main Activity")
            dialogue.setMessage("Dialog bisa ditutup dengan cara klik bagian luar dialog nya")
            dialogue.setCancelable(true)
            dialogue.show()
        }

        binding.showDialogueAction.setOnClickListener {
            val dialogue = AlertDialog.Builder(this)
            dialogue.setTitle("Dialog dengan beberapa button")
            dialogue.setMessage("Dialog dengan Button untuk berbagai aksi")
            dialogue.setIcon(R.mipmap.ic_launcher_round)

            dialogue.setCancelable(false)
            dialogue.setPositiveButton("Positive Button") { dialogInterface, i ->
                Toast.makeText(this, "Positive Button Clicked", Toast.LENGTH_LONG).show()
            }

            dialogue.setNegativeButton("Negative Button"){ dialogInterface, i ->
                Toast.makeText(this, "Negative Button Clicked", Toast.LENGTH_LONG).show()
            }

            dialogue.setNeutralButton("Neutral Button"){ dialogInterface, i ->
                Toast.makeText(this, "Neutral Button Clicked", Toast.LENGTH_LONG).show()
            }
            dialogue.show()
        }

        binding.showDialogueCustom.setOnClickListener {
            val view = LayoutInflater.from(this).inflate(R.layout.custom_dialogue, null, false)
            val dialogBuilder = AlertDialog.Builder(this)
            dialogBuilder.setView(view)

            val dialogue = dialogBuilder.create()
            dialogue.show()
            dialogue.setCancelable(false)

            view.findViewById<Button>(R.id.btnClose).setOnClickListener{
                dialogue.dismiss()
            }

        }

        binding.showDialogueFragment.setOnClickListener {
            val alertDialogFragment = AlertDialogFragment()
            alertDialogFragment.show(supportFragmentManager, "test")
        }
        }
    }