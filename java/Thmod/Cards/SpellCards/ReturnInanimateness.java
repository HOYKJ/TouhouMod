package Thmod.Cards.SpellCards;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.DamageAction;
import com.megacrit.cardcrawl.actions.common.DrawCardAction;
import com.megacrit.cardcrawl.actions.common.ReducePowerAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.localization.CardStrings;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

import java.util.ArrayList;

import Thmod.Actions.common.ChangeOrbAction;
import Thmod.Actions.unique.ChooseAction;
import Thmod.Cards.DeriveCards.ArcherDoll;
import Thmod.Cards.DeriveCards.HeLanDoll;
import Thmod.Cards.DeriveCards.NormalDoll;
import Thmod.Cards.DeriveCards.PengLaiDoll;
import Thmod.Cards.DeriveCards.ShangHaiDoll;
import Thmod.Cards.DeriveCards.ShieldDoll;
import Thmod.Cards.DeriveCards.SpearDoll;
import Thmod.Cards.NingyouShinki;
import Thmod.Orbs.Helan;
import Thmod.Orbs.NingyouOrb;
import Thmod.Orbs.Penglai;
import Thmod.Orbs.Shanghai;
import Thmod.Orbs.TateNingyou;
import Thmod.Orbs.YariNingyou;
import Thmod.Orbs.YumiNingyou;

public class ReturnInanimateness extends AbstractSpellCards {
    public static final String ID = "ReturnInanimateness";
    private static final CardStrings cardStrings;
    public static final String NAME;
    public static final String DESCRIPTION;
    private static final int COST = 1;
    private static final int ATTACK_DMG = 15;
    private int pointcost;

    public ReturnInanimateness() {
        super("ReturnInanimateness", ReturnInanimateness.NAME,  1, ReturnInanimateness.DESCRIPTION, CardType.ATTACK, CardRarity.SPECIAL, CardTarget.ENEMY);
        this.baseDamage = 20;
        this.baseMagicNumber = 2;
        this.magicNumber = this.baseMagicNumber;
        this.pointcost = 3;
    }

    public void use(final AbstractPlayer p, final AbstractMonster m) {
        if (p.hasPower("PointPower")) {
            if (p.getPower("PointPower").amount >= this.pointcost) {
                AbstractDungeon.actionManager.addToTop(new ReducePowerAction(p,p,"PointPower",this.pointcost));
                final ChooseAction choice = new ChooseAction(this, m, ReturnInanimateness.EXTENDED_DESCRIPTION[0], false, 1);
                for (int i = (AbstractDungeon.player.orbs.size() - 1); i >= 0; i--) {
                    final ArrayList<Integer> orbnum = new ArrayList<>();
                    orbnum.clear();
                    orbnum.add(i);
                    if (AbstractDungeon.player.orbs.get(i) instanceof NingyouOrb) {
                        choice.add(new NormalDoll(), () -> {
                            AbstractDungeon.actionManager.addToBottom(new ChangeOrbAction(orbnum.get(0),true));
                            AbstractDungeon.actionManager.addToTop(new DamageAction(m, new DamageInfo(p, this.damage, this.damageTypeForTurn), AbstractGameAction.AttackEffect.BLUNT_LIGHT));
                            AbstractDungeon.actionManager.addToBottom(new DrawCardAction(p, this.magicNumber));
                        });
                    }
                    if (AbstractDungeon.player.orbs.get(i) instanceof YariNingyou) {
                        choice.add(new SpearDoll(), () -> {
                            AbstractDungeon.actionManager.addToBottom(new ChangeOrbAction(orbnum.get(0),false));
                            AbstractDungeon.actionManager.addToTop(new DamageAction(m, new DamageInfo(p, this.damage, this.damageTypeForTurn), AbstractGameAction.AttackEffect.BLUNT_LIGHT));
                            AbstractDungeon.actionManager.addToBottom(new DrawCardAction(p, this.magicNumber));
                        });
                    }
                    if (AbstractDungeon.player.orbs.get(i) instanceof TateNingyou) {
                        choice.add(new ShieldDoll(), () -> {
                            AbstractDungeon.actionManager.addToBottom(new ChangeOrbAction(orbnum.get(0),false));
                            AbstractDungeon.actionManager.addToTop(new DamageAction(m, new DamageInfo(p, this.damage, this.damageTypeForTurn), AbstractGameAction.AttackEffect.BLUNT_LIGHT));
                            AbstractDungeon.actionManager.addToBottom(new DrawCardAction(p, this.magicNumber));
                        });
                    }
                    if (AbstractDungeon.player.orbs.get(i) instanceof YumiNingyou) {
                        choice.add(new ArcherDoll(), () -> {
                            AbstractDungeon.actionManager.addToBottom(new ChangeOrbAction(orbnum.get(0),false));
                            AbstractDungeon.actionManager.addToTop(new DamageAction(m, new DamageInfo(p, this.damage, this.damageTypeForTurn), AbstractGameAction.AttackEffect.BLUNT_LIGHT));
                            AbstractDungeon.actionManager.addToBottom(new DrawCardAction(p, this.magicNumber));
                        });
                    }
                    if (AbstractDungeon.player.orbs.get(i) instanceof Shanghai) {
                        choice.add(new ShangHaiDoll(), () -> {
                            AbstractDungeon.actionManager.addToBottom(new ChangeOrbAction(orbnum.get(0),false));
                            AbstractDungeon.actionManager.addToTop(new DamageAction(m, new DamageInfo(p, this.damage, this.damageTypeForTurn), AbstractGameAction.AttackEffect.BLUNT_LIGHT));
                            AbstractDungeon.actionManager.addToBottom(new DrawCardAction(p, this.magicNumber));
                        });
                    }
                    if (AbstractDungeon.player.orbs.get(i) instanceof Penglai) {
                        choice.add(new PengLaiDoll(), () -> {
                            AbstractDungeon.actionManager.addToBottom(new ChangeOrbAction(orbnum.get(0),false));
                            AbstractDungeon.actionManager.addToTop(new DamageAction(m, new DamageInfo(p, this.damage, this.damageTypeForTurn), AbstractGameAction.AttackEffect.BLUNT_LIGHT));
                            AbstractDungeon.actionManager.addToBottom(new DrawCardAction(p, this.magicNumber));
                        });
                    }
                    if (AbstractDungeon.player.orbs.get(i) instanceof Helan) {
                        choice.add(new HeLanDoll(), () -> {
                            AbstractDungeon.actionManager.addToBottom(new ChangeOrbAction(orbnum.get(0),false));
                            AbstractDungeon.actionManager.addToTop(new DamageAction(m, new DamageInfo(p, this.damage, this.damageTypeForTurn), AbstractGameAction.AttackEffect.BLUNT_LIGHT));
                            AbstractDungeon.actionManager.addToBottom(new DrawCardAction(p, this.magicNumber));
                        });
                    }
                }
                AbstractDungeon.actionManager.addToBottom(choice);
            }
        }
    }

    public boolean canUse(AbstractPlayer p, AbstractMonster m){
        super.canUse(p,m);
        if (p.hasPower("PointPower")) {
            if (p.getPower("PointPower").amount >= this.pointcost) {
                return true;
            }
        }
        this.cantUseMessage = AbstractSpellCards.EXTENDED_DESCRIPTION[4];
        return false;
    }

    public AbstractCard makeCopy() {
        return new ReturnInanimateness();
    }

    public void upgrade() {
        if (!(this.upgraded)) {
            this.upgradeName();
        }
    }

    static {
        cardStrings = CardCrawlGame.languagePack.getCardStrings("ReturnInanimateness");
        NAME = ReturnInanimateness.cardStrings.NAME;
        DESCRIPTION = ReturnInanimateness.cardStrings.DESCRIPTION;
    }
}
