package com.storydokkebi.ui;

import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.widget.TextFieldWidget;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.text.Text;
import net.minecraft.client.util.math.MatrixStack;

public class StoryScreen extends Screen {
    private TextFieldWidget field;

    public StoryScreen() {
        super(Text.literal("Сюжет"));
    }

    @Override
    protected void init() {
        field = new TextFieldWidget(textRenderer, width/2-100, height/2-30, 200,20, Text.literal(""));
        field.setText("Добро пожаловать в сюжет NeoSeoul: Dokkebi!");
        addSelectableChild(field);
        addDrawableChild(ButtonWidget.builder(Text.literal("Сохранить"), b -> this.close())
            .dimensions(width/2-40, height/2+10,80,20).build());
    }

    @Override
    public void render(MatrixStack m,int x,int y,float d){
        renderBackground(m);
        drawCenteredText(m,textRenderer,"Редактор сюжета",width/2,height/2-60,0xFFFFFF);
        field.render(m,x,y,d);
        super.render(m,x,y,d);
    }
}