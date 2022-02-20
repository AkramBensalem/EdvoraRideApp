package dz.akram.bensalem.edvorarideapp.ui.components.homescreen

import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.compose.AsyncImagePainter
import coil.request.ImageRequest
import com.google.accompanist.insets.statusBarsPadding
import dz.akram.bensalem.edvorarideapp.data.User
import dz.akram.bensalem.edvorarideapp.ui.theme.captionTypography
import dz.akram.bensalem.edvorarideapp.ui.theme.titleTypography
import dz.akram.bensalem.edvorarideapp.utils.internationalization.LocalStrings
import timber.log.Timber

@Composable
fun CustomAppBar(
    modifier: Modifier = Modifier,
    profile: User,
    onProfileClicked: () -> Unit = {}
) {

    val strings = LocalStrings.current

    TopAppBar(
        modifier = modifier
            .statusBarsPadding(),
        backgroundColor = MaterialTheme.colors.background,
        elevation = 0.dp,
        title = {
            Text(
                text = strings.appName,
                style = titleTypography(color = MaterialTheme.colors.onPrimary)
            )
        },
        actions = {

            Text(
                text = profile.name,
                style = captionTypography(color = MaterialTheme.colors.onBackground)
            )

            IconButton(onClick = onProfileClicked) {
                AsyncImage(
                    model = ImageRequest.Builder(LocalContext.current)
                        .data(profile.profileKey)
                        .crossfade(true)
                        .build(),
                    // for accessibility
                    contentDescription = strings.profileIcon,
                    onState = {
                        when (it) {
                            AsyncImagePainter.State.Empty -> {
                                Timber.d("empty")
                            }
                            is AsyncImagePainter.State.Loading -> {
                                Timber.d("loading")
                            }
                            is AsyncImagePainter.State.Success -> {
                                Timber.d("success")
                            }
                            is AsyncImagePainter.State.Error -> {
                                Timber.d("error")
                            }
                        }
                    },
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .size(24.dp)
                        .clip(CircleShape)
                )
            }
        }
    )
}



