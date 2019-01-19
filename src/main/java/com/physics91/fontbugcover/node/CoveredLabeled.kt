package com.physics91.fontbugcover.node

import javafx.embed.swing.SwingNode
import javafx.scene.text.FontWeight
import java.awt.Font
import javax.swing.JLabel
import kotlin.properties.Delegates

/**
 *
 *
 * @author kimjaeyeong
 * @since 0.1
 */
abstract class CoveredLabeled : SwingNode() {

    val jLabel = JLabel()
    private var text: String by Delegates.observable("") { _, _, newValue ->
        jLabel.text = newValue
    }
    private var textStyle: FontWeight by Delegates.observable(FontWeight.NORMAL) { _, _, nv ->
        textStyleForm(nv)
    }

    init {
        jLabel.text = text
        textStyleForm(textStyle)
        content = jLabel
    }

    private fun textStyleForm(textStyle: FontWeight) {
        val f = jLabel.font
        when (textStyle) {
            FontWeight.NORMAL -> jLabel.font = f.deriveFont(f.style or Font.BOLD)
            FontWeight.BOLD -> jLabel.font = f.deriveFont(f.style and Font.BOLD)
            else -> {
            }
        }
    }
}