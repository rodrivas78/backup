import androidx.appcompat.app.AppCompatActivity
import android.content.Intent
import android.net.Uri
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        
        // Find the CardView elements by their IDs
        val card1 = findViewById<CardView>(R.id.card1)
        val card2 = findViewById<CardView>(R.id.card2)
        val card3 = findViewById<CardView>(R.id.card3)
        val card4 = findViewById<CardView>(R.id.card4)
        
        // Set click listeners on the CardView elements
        card1.setOnClickListener {
            // Launch a second activity when card1 is clicked
            val intent = Intent(this, SecondActivity::class.java)
            startActivity(intent)
        }
        
        card2.setOnClickListener {
            // Open an external link when card2 is clicked
            val uri = Uri.parse("https://www.example.com")
            val intent = Intent(Intent.ACTION_VIEW, uri)
            startActivity(intent)
        }
        
        card3.setOnClickListener {
            // Handle click on card3
        }
        
        card4.setOnClickListener {
            // Handle click on card4
        }
    }
}
