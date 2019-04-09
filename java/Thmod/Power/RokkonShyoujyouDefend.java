package Thmod.Power;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.common.DamageAction;
import com.megacrit.cardcrawl.actions.common.ReducePowerAction;
import com.megacrit.cardcrawl.actions.common.RemoveSpecificPowerAction;
import com.megacrit.cardcrawl.actions.unique.RemoveDebuffsAction;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.helpers.ImageMaster;
import com.megacrit.cardcrawl.localization.PowerStrings;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.AbstractPower;

import Thmod.Actions.unique.RemoveBuffsAction;

public class RokkonShyoujyouDefend extends AbstractPower {
    public static final String POWER_ID = "RokkonShyoujyouDefend";
    private static final PowerStrings powerStrings = CardCrawlGame.languagePack.getPowerStrings("RokkonShyoujyouDefend");
    public static final String NAME = powerStrings.NAME;
    public static final String[] DESCRIPTIONS = powerStrings.DESCRIPTIONS;
    private AbstractPlayer p;
    private int damage;
    private boolean isEnemy;

    public RokkonShyoujyouDefend(AbstractCreature owner, int Amount) {
        this(owner, Amount, false);
    }

    public RokkonShyoujyouDefend(AbstractCreature owner, int Amount, boolean isEnemy) {
        this.name = NAME;
        this.ID = "RokkonShyoujyouDefend";
        this.owner = owner;
        this.amount = -1;
        updateDescription();
        this.img = ImageMaster.loadImage("images/power/32/RokkonShyoujyouDefend.png");
        this.type = PowerType.BUFF;
        this.damage = Amount;
        this.isEnemy = isEnemy;
        this.p = AbstractDungeon.player;
    }

    public int onAttacked(DamageInfo info, int damageAmount)
    {
        if ((info.type != DamageInfo.DamageType.HP_LOSS) && (info.owner != null) && (info.owner != this.owner)) {
            if (damageAmount > 0) {
                flash();
                if(!this.isEnemy) {
                    for (int i = 0; i < AbstractDungeon.getCurrRoom().monsters.monsters.size(); i++) {
                        AbstractMonster target = AbstractDungeon.getCurrRoom().monsters.monsters.get(i);
                        if ((!(target.isDying)) && (target.currentHealth > 0) && (!(target.isEscaping))) {
                            AbstractDungeon.actionManager.addToBottom(new RemoveBuffsAction(target));
                            AbstractDungeon.actionManager.addToBottom(new DamageAction(target, new DamageInfo(this.p, this.damage, DamageInfo.DamageType.THORNS), AbstractGameAction.AttackEffect.BLUNT_HEAVY));
                        }
                    }
                    if (!(p.hasPower("PointPower"))) {
                        AbstractDungeon.actionManager.addToBottom(new ApplyPowerAction(this.p, this.p, new PointPower(this.p, 1), 1));
                    } else if (p.getPower("PointPower").amount < 5) {
                        AbstractDungeon.actionManager.addToBottom(new ApplyPowerAction(this.p, this.p, new PointPower(this.p, 1), 1));
                    }
                }
                else {
                    AbstractDungeon.actionManager.addToBottom(new RemoveBuffsAction(p));
                    AbstractDungeon.actionManager.addToBottom(new DamageAction(this.p, new DamageInfo(this.p, this.damage, DamageInfo.DamageType.THORNS), AbstractGameAction.AttackEffect.BLUNT_HEAVY));
                }
                AbstractDungeon.actionManager.addToBottom(new RemoveSpecificPowerAction(this.owner, this.owner, this));
                return 0;
            }
            return damageAmount;
        }
        return damageAmount;
    }

    public void updateDescription()
    {
        this.description = DESCRIPTIONS[0];
    }
}
