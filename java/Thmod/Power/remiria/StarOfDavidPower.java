package Thmod.Power.remiria;

import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.common.ExhaustSpecificCardAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.helpers.ImageMaster;
import com.megacrit.cardcrawl.localization.PowerStrings;
import com.megacrit.cardcrawl.powers.AbstractPower;
import com.megacrit.cardcrawl.powers.StrengthPower;

import Thmod.Actions.Remiria.MakeCardInHandAction;
import Thmod.Actions.Remiria.PlusCardAction;
import Thmod.Actions.common.LatterAction;
import Thmod.Actions.unique.ChooseAction;
import Thmod.Cards.ScarletCard.Absorbed;
import Thmod.Cards.ScarletCard.AbstractRemiriaCards;

public class StarOfDavidPower extends AbstractPower {
    public static final String POWER_ID = "StarOfDavidPower";
    private static final PowerStrings powerStrings = CardCrawlGame.languagePack.getPowerStrings("StarOfDavidPower");
    public static final String NAME = powerStrings.NAME;
    public static final String[] DESCRIPTIONS = powerStrings.DESCRIPTIONS;

    public StarOfDavidPower(AbstractCreature owner, int amount) {
        this.name = NAME;
        this.ID = "StarOfDavidPower";
        this.owner = owner;
        this.amount = amount;
        updateDescription();
        this.img = ImageMaster.loadImage("images/power/32/remiria/StarOfDavidPower.png");
        this.type = PowerType.BUFF;
    }

    @Override
    public void atStartOfTurnPostDraw() {
        super.atStartOfTurnPostDraw();
        this.trigger();
    }

    public void trigger(){
        AbstractPlayer p = AbstractDungeon.player;
        AbstractDungeon.actionManager.addToBottom(new LatterAction(()->{
            final ChooseAction choice = new ChooseAction(null, null, Absorbed.EXTENDED_DESCRIPTION[2], true, this.amount);
            for (AbstractCard card : p.hand.group) {
                choice.add(card, () -> {
                    AbstractDungeon.actionManager.addToBottom(new ExhaustSpecificCardAction(card, p.hand));
                    AbstractCard card1 = AbstractDungeon.returnTrulyRandomCard().makeCopy();
                    if(card1 instanceof AbstractRemiriaCards){
                        ((AbstractRemiriaCards) card1).plusCard();
                    }
                    AbstractDungeon.actionManager.addToBottom(new MakeCardInHandAction(card1));
                });
            }
            AbstractDungeon.actionManager.addToBottom(choice);
        },0.1f));
    }

    public void updateDescription()
    {
        this.description = DESCRIPTIONS[0] + this.amount + DESCRIPTIONS[1];
    }
}
