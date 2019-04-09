package Thmod.Power;

import com.megacrit.cardcrawl.actions.common.GainBlockAction;
import com.megacrit.cardcrawl.actions.common.MakeTempCardInHandAction;
import com.megacrit.cardcrawl.actions.common.RemoveSpecificPowerAction;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.helpers.ImageMaster;
import com.megacrit.cardcrawl.localization.PowerStrings;
import com.megacrit.cardcrawl.powers.AbstractPower;

import Thmod.Cards.ElementCards.UncommonCards.MidautumnSpear;
import Thmod.ThMod;

public class NextSpear extends AbstractPower {
    public static final String POWER_ID = "NextSpear";
    private static final PowerStrings powerStrings = CardCrawlGame.languagePack.getPowerStrings("NextSpear");
    public static final String NAME = powerStrings.NAME;
    public static final String[] DESCRIPTIONS = powerStrings.DESCRIPTIONS;
    private static int spearIdOffset;
    private int damage;

    public NextSpear(AbstractCreature owner, int damage) {
        this.name = NAME;
        this.ID = "NextSpear" + spearIdOffset;
        spearIdOffset += 1;
        this.owner = owner;
        this.amount = damage;
        this.img = ImageMaster.loadImage("images/power/32/NextSpear.png");
        this.type = PowerType.DEBUFF;
        this.damage = damage;
        updateDescription();
    }

//    public void atEndOfTurn(boolean isPlayer) {
//        if(!(isPlayer)) {
//            AbstractDungeon.actionManager.addToTop(new DamageAction(this.owner, new DamageInfo(this.owner, this.damage, DamageInfo.DamageType.THORNS), AbstractGameAction.AttackEffect.BLUNT_HEAVY));
//            AbstractDungeon.actionManager.addToBottom(new RemoveSpecificPowerAction(this.owner, this.owner, this));
//        }
//    }


    @Override
    public void atEndOfTurn(boolean isPlayer) {
        super.atEndOfTurn(isPlayer);
        if(!isPlayer) {
            AbstractDungeon.actionManager.addToBottom(new MakeTempCardInHandAction(new MidautumnSpear(this.damage), false));
        }
    }

    @Override
    public void atStartOfTurnPostDraw() {
        super.atStartOfTurnPostDraw();
        AbstractDungeon.actionManager.addToBottom(new GainBlockAction(AbstractDungeon.player, AbstractDungeon.player, (int) ((float)this.damage / 2)));
        AbstractDungeon.actionManager.addToBottom(new RemoveSpecificPowerAction(this.owner, this.owner, this));
    }

    public void updateDescription()
    {
        this.description = DESCRIPTIONS[0] + this.damage + DESCRIPTIONS[1];
    }
}
