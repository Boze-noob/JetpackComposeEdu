import android.util.Log
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.applid.gym.R
import com.applid.gym.common.Constants
import com.applid.gym.ui.view_models.home.appBar.AppBarViewModel
import com.applid.gym.ui.view_models.home.discoverWorkouts.DiscoverWorkoutsViewModel

@Composable
fun HomeAppBar(
    mainTxt: String,
    descriptionTxt: String,
    viewModel: AppBarViewModel = hiltViewModel()
    ) {

    val state = viewModel.state.value

    Column() {
        Row(
            modifier = Modifier.padding(horizontal = 15.dp, vertical = 20.dp)
        ) {
            Column(
                modifier = Modifier.padding(vertical = 10.dp)
            ) {
                Text(text = mainTxt, style = MaterialTheme.typography.h1)
                Text(text = descriptionTxt, style = MaterialTheme.typography.subtitle1)
            }

            Spacer(Modifier.weight(1f))
            Card(
                modifier = Modifier.size(55.dp),
                border = BorderStroke(3.dp, MaterialTheme.colors.secondaryVariant),
                shape = CircleShape,
                elevation = 2.dp,
            ) {
                AsyncImage(
                    model = ImageRequest.Builder(LocalContext.current)
                        .data(Constants.IMAGE_BASE_URL + state.webImageModel?.url)
                        .crossfade(true)
                        .build(),
                    contentDescription = "",
                    placeholder = painterResource(R.drawable.default_profile_img),
                    error = painterResource(id = R.drawable.default_profile_img),
                    contentScale = ContentScale.Crop,
                    onError = {
                        Log.d("DiscoverWorkout", "Image loading error ${it.result.throwable}")
                    },
                    modifier = Modifier.fillMaxSize(),
                )
            }
        }
    }
}