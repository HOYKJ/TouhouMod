package Thmod.Characters;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.math.MathUtils;
import com.esotericsoftware.spine.AnimationState;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.core.EnergyManager;
import com.megacrit.cardcrawl.core.Settings;
import com.megacrit.cardcrawl.helpers.ImageMaster;
import com.megacrit.cardcrawl.screens.CharSelectInfo;
import com.megacrit.cardcrawl.unlock.UnlockTracker;

import java.util.ArrayList;

import Thmod.Cards.Dash_Komeiji;
import Thmod.Cards.Defend_Komeiji;
import Thmod.Cards.NingyouFukuhei;
import Thmod.Cards.NingyouShinki;
import Thmod.Cards.Strike_Komeiji;
import Thmod.Patches.CharacterEnum;
import Thmod.ThMod;
import basemod.abstracts.CustomPlayer;

public class KomeijiSatori extends CustomPlayer {
    public static final int ENERGY_PER_TURN = 3;
    public static final String[] orbTextures;
    public static final String orbVfx;

    public KomeijiSatori(final String name, final PlayerClass setClass) {
        super(name, setClass, orbTextures, orbVfx, (String) null, null);

        this.dialogX = this.drawX + 0.0f * Settings.scale;
        this.dialogY = this.drawY + 240.0f * Settings.scale;
        ThMod.orbAtlas = new TextureAtlas(Gdx.files.internal("images/orbs/Komeiji/orb.atlas"));
        AbstractCard.orb_red = ThMod.orbAtlas.findRegion("komeiji");
        ImageMaster.RED_ORB = ThMod.orbAtlas.findRegion("komeiji");

        this.initializeClass(null, "images/characters/komeiji/shoulder.png", "images/characters/komeiji/shoulder2.png", "images/characters/komeiji/corpse.png", getLoadout(), 0.0F, 5.0F, 240.0F, 300.0F, new EnergyManager(ENERGY_PER_TURN));
        loadAnimation("images/characters/komeiji/Komeiji.atlas", "images/characters/komeiji/Komeiji.json", 1.0F);
        AnimationState.TrackEntry e = this.state.setAnimation(0, "Normal", true);
        e.setTime(e.getEndTime() * MathUtils.random());
        e.setTimeScale(1.0F);
    }

    public static ArrayList<String> getStartingDeck() {
        ArrayList<String> retVal = new ArrayList<>();
        retVal.add(Strike_Komeiji.ID);
        retVal.add(Strike_Komeiji.ID);
        retVal.add(Strike_Komeiji.ID);
        retVal.add(Strike_Komeiji.ID);
        retVal.add(Defend_Komeiji.ID);
        retVal.add(Defend_Komeiji.ID);
        retVal.add(Defend_Komeiji.ID);
        retVal.add(Defend_Komeiji.ID);
        retVal.add(Dash_Komeiji.ID);
//        retVal.add(NingyouFukuhei.ID);
//        retVal.add(NingyouShinki.ID);
        return retVal;
    }

    public static ArrayList<String> getStartingRelics() {
        ArrayList<String> retVal = new ArrayList<>();
        retVal.add("KomeijisEye");
        UnlockTracker.markRelicAsSeen("KomeijisEye");
        retVal.add("SpellCardsRule");
        UnlockTracker.markRelicAsSeen("SpellCardsRule");
        return retVal;
    }

    public static CharSelectInfo getLoadout() {
        int maxOrbs;
        if(ThMod.AliceOpen)
            maxOrbs = 5;
        else
            maxOrbs = 4;
        return new CharSelectInfo("古明地 觉", "觉从一次昏迷中醒来后,发现自己处在一个不知名的高塔中, NL 她所有的,只有一本符卡规则,和记忆中零散的符卡.",
                50, 50, maxOrbs, 99, 4,
                CharacterEnum.KomeijiSatori, getStartingRelics(), getStartingDeck(), false);
    }

    static {
        orbTextures = new String[] {
                "images/ui/topPanel/Komeiji/layer1.png","images/ui/topPanel/Komeiji/layer2.png","images/ui/topPanel/Komeiji/layer3.png","images/ui/topPanel/Komeiji/layer4.png","images/ui/topPanel/Komeiji/layer5.png","images/ui/topPanel/Komeiji/layer6.png",
                "images/ui/topPanel/Komeiji/layer1d.png","images/ui/topPanel/Komeiji/layer2d.png","images/ui/topPanel/Komeiji/layer3d.png","images/ui/topPanel/Komeiji/layer4d.png","images/ui/topPanel/Komeiji/layer5d.png",
        };
        orbVfx = "images/ui/topPanel/energyKomeijiVFX.png";
    }
}

