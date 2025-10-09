package app.isaruff.budgettracker.presentation.ui_toolkit.theme

import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import budgettracker.composeapp.generated.resources.*
import org.jetbrains.compose.resources.Font


val SyneFontFamily: FontFamily
    @Composable
    get() = FontFamily(
        Font(Res.font.syne_regular, FontWeight.Normal, FontStyle.Normal),
        Font(Res.font.syne_medium, FontWeight.Medium, FontStyle.Normal),
        Font(Res.font.syne_semibold, FontWeight.SemiBold, FontStyle.Normal),
        Font(Res.font.syne_bold, FontWeight.Bold, FontStyle.Normal),
        Font(Res.font.syne_extrabold, FontWeight.ExtraBold, FontStyle.Normal),
    )

val LexendMegaFontFamily: FontFamily
    @Composable
    get() = FontFamily(
        Font(Res.font.lexendmega_light, FontWeight.Light, FontStyle.Normal),
        Font(Res.font.lexendmega_semibold, FontWeight.SemiBold, FontStyle.Normal),
        Font(Res.font.lexendmega_bold, FontWeight.Bold, FontStyle.Normal),
        Font(Res.font.lexendmega_thin, FontWeight.Thin, FontStyle.Normal),
        Font(Res.font.lexendmega_black, FontWeight.Black, FontStyle.Normal),
        Font(Res.font.lexendmega_light, FontWeight.Light, FontStyle.Normal),
        Font(Res.font.lexendmega_extrabold, FontWeight.ExtraBold, FontStyle.Normal),
        Font(Res.font.lexendmega_extralight, FontWeight.ExtraLight, FontStyle.Normal),
        Font(Res.font.lexendmega_medium, FontWeight.Medium, FontStyle.Normal),
        Font(Res.font.lexendmega_regular, FontWeight.Normal, FontStyle.Normal),
    )


