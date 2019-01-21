package com.physics91.fontbugcover.node

import javafx.embed.swing.SwingNode
import javafx.scene.text.FontWeight
import java.awt.Color
import java.awt.Font
import javax.swing.JLabel
import kotlin.properties.Delegates

/**
 * Swing으로 덮기
 *
 * @author kimjaeyeong
 * @since 0.1
 */
abstract class CoveredLabeled : SwingNode() {

    val jLabel = JLabel()
    var text: String by Delegates.observable("") { _, _, newValue ->
        jLabel.text = newValue
    }
    var textStyle: FontWeight by Delegates.observable(FontWeight.NORMAL) { _, _, nv ->
        textStyleForm(nv)
    }
    var textSize: Float by Delegates.observable(0f) { _, _, newValue ->
        jLabel.font = jLabel.font.deriveFont(newValue)
    }

    init {
        jLabel.text = text
        jLabel.background = Color.getColor("#00ffffff")
        textSize = 15f
        textStyleForm(textStyle)
        content = jLabel
    }

    private fun textStyleForm(textStyle: FontWeight) {
        val f = jLabel.font
        when (textStyle) {
            FontWeight.NORMAL -> jLabel.font = f.deriveFont(f.style or 0)
            FontWeight.BOLD -> jLabel.font = f.deriveFont(f.style or Font.BOLD)
            else -> {
            }
        }
    }
}