import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import kotlinx.coroutines.*
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.TextView
import androidx.cardview.widget.CardView

class MainActivity : AppCompatActivity() {
    private lateinit var loadingCard: CardView
    private lateinit var contentCard: CardView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Find the CardView elements by their IDs
        val card1 = findViewById<CardView>(R.id.card1)
        val card2 = findViewById<CardView>(R.id.card2)
        val card3 = findViewById<CardView>(R.id.card3)
        val card4 = findViewById<CardView>(R.id.card4)

        // Set up a ViewModel to load content
        val viewModel = ViewModelProvider(this).get(MyViewModel::class.java)

        // Set up the loading card
        val inflater = LayoutInflater.from(this)
        loadingCard = inflater.inflate(R.layout.loading_card, null) as CardView
        contentCard = findViewById(R.id.card3)

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
            // Show the loading card
            contentCard.visibility = View.GONE
            loadingCard.visibility = View.VISIBLE

            // Set up a coroutine to wait for the ViewModel to load content
            GlobalScope.launch {
                val content = viewModel.loadContent()

                // Update the view with the loaded content
                withContext(Dispatchers.Main) {
                    val textView = findViewById<TextView>(R.id.card3_text)
                    textView.text = content

                    // Hide the loading card and show the content card
                    loadingCard.visibility = View.GONE
                    contentCard.visibility = View.VISIBLE
                }
            }
        }

        card4.setOnClickListener {
            // Handle click on card4
        }
    }
}

class MyViewModel : ViewModel() {
    suspend fun loadContent(): String {
        // Simulate loading content from a remote server
        delay(5000)
        return "Loaded content"
    }
}
