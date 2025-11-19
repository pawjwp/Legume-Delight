package net.pawjwp.legumedelight.item;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import vectorwing.farmersdelight.common.registry.ModEffects;

import static vectorwing.farmersdelight.common.FoodValues.BRIEF_DURATION;
import static vectorwing.farmersdelight.common.FoodValues.SHORT_DURATION;
import static vectorwing.farmersdelight.common.FoodValues.MEDIUM_DURATION;
import static vectorwing.farmersdelight.common.FoodValues.LONG_DURATION;

public class LegumeDelightFoodValues {
    // Raw Crops
    public static final FoodProperties BEANS = (new FoodProperties.Builder())
            .nutrition(1).saturationMod(0.4f).build();
    public static final FoodProperties PEANUTS = (new FoodProperties.Builder())
            .nutrition(1).saturationMod(0.4f).build();

    // Basic Foods
    public static final FoodProperties BEAN_PASTE = (new FoodProperties.Builder())
            .nutrition(3).saturationMod(0.4f).build();
    public static final FoodProperties BEAN_PATTY = (new FoodProperties.Builder())
            .nutrition(4).saturationMod(0.8f).fast().build();
    public static final FoodProperties PEANUT_BUTTER = (new FoodProperties.Builder())
            .nutrition(3).saturationMod(0.4f).build();
    public static final FoodProperties REFRIED_BEANS = (new FoodProperties.Builder())
            .nutrition(3).saturationMod(0.4f).build();
    public static final FoodProperties ROASTED_PEANUTS = (new FoodProperties.Builder())
            .nutrition(3).saturationMod(0.5f).fast().build();

    // Sweets
    public static final FoodProperties CANDIED_PEANUTS = (new FoodProperties.Builder())
            .nutrition(4).saturationMod(0.5f).fast()
            .effect(() -> new MobEffectInstance(MobEffects.MOVEMENT_SPEED, BRIEF_DURATION, 0), 1.0F).build();
        // Mooncake (use pie slice values)
        public static final FoodProperties PEANUT_BAR = (new FoodProperties.Builder())
                .nutrition(5).saturationMod(0.8f).fast().build();
        // Peanut butter cookie (use cookie value)
        // Peanut butter cup (use cookie value)
        // Rice cake (use cake slice value)
        public static final FoodProperties TRAIL_MIX = (new FoodProperties.Builder())
                .nutrition(5).saturationMod(0.8f).fast().build();

    // Handheld Foods
    public static final FoodProperties BEAN_BURGER = (new FoodProperties.Builder())
            .nutrition(11).saturationMod(0.8f).build();
    public static final FoodProperties BEAN_BURRITO = (new FoodProperties.Builder())
            .nutrition(12).saturationMod(0.8f).build();
    public static final FoodProperties BEANS_ON_TOAST = (new FoodProperties.Builder())
            .nutrition(4).saturationMod(0.6f).build();
    /*public static final FoodProperties NACHOS = (new FoodProperties.Builder())
            .nutrition(7).saturationMod(0.6f).build();*/
    public static final FoodProperties PEANUT_BUTTER_AND_JAM_SANDWICH = (new FoodProperties.Builder())
            .nutrition(10).saturationMod(0.8f).build();
    /*public static final FoodProperties POTATO_TACO = (new FoodProperties.Builder())
           .nutrition(10).saturationMod(0.7f).build();*/

    // Bowl Foods
    public static final FoodProperties BAKED_BEANS = (new FoodProperties.Builder())
            .nutrition(10).saturationMod(0.8f)
            .effect(() -> new MobEffectInstance(ModEffects.COMFORT.get(), MEDIUM_DURATION, 0), 1.0F).build();
    public static final FoodProperties BEANS_AND_RICE = (new FoodProperties.Builder())
            .nutrition(10).saturationMod(0.7f)
            .effect(() -> new MobEffectInstance(ModEffects.COMFORT.get(), SHORT_DURATION, 0), 1.0F).build();
    public static final FoodProperties CHILI = (new FoodProperties.Builder())
            .nutrition(13).saturationMod(0.8f)
            .effect(() -> new MobEffectInstance(ModEffects.COMFORT.get(), MEDIUM_DURATION, 0), 1.0F).build();
    public static final FoodProperties PAD_THAI = (new FoodProperties.Builder())
            .nutrition(14).saturationMod(0.8f)
            .effect(() -> new MobEffectInstance(ModEffects.COMFORT.get(), LONG_DURATION, 0), 1.0F).build();

    // Plated Foods
    public static final FoodProperties PASTA_WITH_TOMATO_SAUCE = (new FoodProperties.Builder())
            .nutrition(8).saturationMod(0.7f)
            .effect(() -> new MobEffectInstance(ModEffects.NOURISHMENT.get(), SHORT_DURATION, 0), 1.0F).build();
}
