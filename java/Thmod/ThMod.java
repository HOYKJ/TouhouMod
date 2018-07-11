package Thmod;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.evacipated.cardcrawl.modthespire.lib.SpireConfig;
import com.evacipated.cardcrawl.modthespire.lib.SpireInitializer;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.core.Settings;
import com.megacrit.cardcrawl.helpers.CardHelper;
import com.megacrit.cardcrawl.helpers.FontHelper;
import com.megacrit.cardcrawl.helpers.RelicLibrary;
import com.megacrit.cardcrawl.localization.CardStrings;
import com.megacrit.cardcrawl.localization.PowerStrings;
import com.megacrit.cardcrawl.localization.RelicStrings;
import com.megacrit.cardcrawl.localization.UIStrings;
import com.megacrit.cardcrawl.vfx.RestartForChangesEffect;


import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Properties;

import Thmod.Cards.Agarareta;
import Thmod.Cards.DemonLordCradle;
import Thmod.Cards.Demotivation;
import Thmod.Cards.DochyakuKami;
import Thmod.Cards.HagoromoMizu;
import Thmod.Cards.Dash_Komeiji;
import Thmod.Cards.Defend_Komeiji;
import Thmod.Cards.InscribeRedSoul;
import Thmod.Cards.ItemCards.ByoukiHeiyu;
import Thmod.Cards.ItemCards.FusyokuKusuri;
import Thmod.Cards.ItemCards.HisouNoKenItem;
import Thmod.Cards.ItemCards.IbukiHisyaku;
import Thmod.Cards.ItemCards.MajikkuPosyun;
import Thmod.Cards.ItemCards.Namazu;
import Thmod.Cards.ItemCards.ReiGeki;
import Thmod.Cards.ItemCards.RyuuSei;
import Thmod.Cards.ItemCards.SaSen;
import Thmod.Cards.ItemCards.SanbutsuTenmizu;
import Thmod.Cards.ItemCards.SeigyoBou;
import Thmod.Cards.ItemCards.SutoppuWocchi;
import Thmod.Cards.JyouchiJin;
import Thmod.Cards.KeiseiJin;
import Thmod.Cards.KinbakuJin;
import Thmod.Cards.KochyouYume;
import Thmod.Cards.MagicStarsSword;
import Thmod.Cards.MakuraSeki;
import Thmod.Cards.Melting;
import Thmod.Cards.Sabishigari;
import Thmod.Cards.Mishyaguji;
import Thmod.Cards.RareCards.AbyssNova;
import Thmod.Cards.RareCards.EverywhereHibernate;
import Thmod.Cards.RareCards.HagoromoKu;
import Thmod.Cards.RareCards.HisouTensoku;
import Thmod.Cards.RareCards.IceTornado;
import Thmod.Cards.RareCards.JigokuNoTaiyou;
import Thmod.Cards.RareCards.LunaDial;
import Thmod.Cards.RareCards.LunaticRedEyes;
import Thmod.Cards.RareCards.MunenMusou;
import Thmod.Cards.RareCards.MusouMyousyu;
import Thmod.Cards.RareCards.TenguhouSokujitsuken;
import Thmod.Cards.RareCards.TerribleSouvenir;
import Thmod.Cards.RareCards.WumiGaWareru;
import Thmod.Cards.RareCards.YuumeiNoKurin;
import Thmod.Cards.SpellCards.BurariHaieki;
import Thmod.Cards.SpellCards.DaiesanShikkaiKoroshi;
import Thmod.Cards.SpellCards.DeepEcologicalBomb;
import Thmod.Cards.SpellCards.DraculaCradle;
import Thmod.Cards.SpellCards.EasyMasterSpark;
import Thmod.Cards.SpellCards.EnshinRoten;
import Thmod.Cards.SpellCards.FusekiShinmei;
import Thmod.Cards.SpellCards.FuumaJin;
import Thmod.Cards.SpellCards.GensouFuubi;
import Thmod.Cards.SpellCards.HagoromoToki;
import Thmod.Cards.SpellCards.HangonChyou;
import Thmod.Cards.SpellCards.HappouKibaku;
import Thmod.Cards.SpellCards.HeartBreak;
import Thmod.Cards.SpellCards.Kamaitachi;
import Thmod.Cards.SpellCards.KokushiMusou;
import Thmod.Cards.SpellCards.KyoufuSaimin;
import Thmod.Cards.SpellCards.MirenKamai;
import Thmod.Cards.SpellCards.Mireniamu;
import Thmod.Cards.SpellCards.MissingPurplePower;
import Thmod.Cards.SpellCards.MoozeNoKiseki;
import Thmod.Cards.SpellCards.MoukoNaikei;
import Thmod.Cards.SpellCards.MusouTensei;
import Thmod.Cards.SpellCards.MusuNoTegata;
import Thmod.Cards.SpellCards.RapurasuNoMa;
import Thmod.Cards.SpellCards.RokkonShyoujyou;
import Thmod.Cards.SpellCards.SakuraHirame;
import Thmod.Cards.SpellCards.SakuyaNoSekai;
import Thmod.Cards.SpellCards.SeikonRyuuri;
import Thmod.Cards.SpellCards.SenseofCherryBlossom;
import Thmod.Cards.SpellCards.SpeartheGungnir;
import Thmod.Cards.SpellCards.TaihouKen;
import Thmod.Cards.SpellCards.TaihouTsuigeki;
import Thmod.Cards.SpellCards.TenkeiKisyou;
import Thmod.Cards.SpellCards.YomeiIkubaku;
import Thmod.Cards.SuitokuNoKyoryu;
import Thmod.Cards.UncommonCards.DemonsDinnerFork;
import Thmod.Cards.UncommonCards.FreezeToughMe;
import Thmod.Cards.UncommonCards.GasuOrimono;
import Thmod.Cards.UncommonCards.GroundStardust;
import Thmod.Cards.UncommonCards.HenyouMirume;
import Thmod.Cards.UncommonCards.HisouNoKen;
import Thmod.Cards.UncommonCards.KimairaNoYoku;
import Thmod.Cards.UncommonCards.KoKei;
import Thmod.Cards.UncommonCards.KokorosuKi;
import Thmod.Cards.UncommonCards.KouPou;
import Thmod.Cards.UncommonCards.MajikuruSanhai;
import Thmod.Cards.UncommonCards.MissingPower;
import Thmod.Cards.UncommonCards.MusuNoYume;
import Thmod.Cards.UncommonCards.NarrowSpark;
import Thmod.Cards.UncommonCards.NingyouSousou;
import Thmod.Cards.PerfectMaid;
import Thmod.Cards.SpellCards.FinalSpark;
import Thmod.Cards.UncommonCards.RoshinSou;
import Thmod.Cards.UncommonCards.SatsujinDooru;
import Thmod.Cards.Strike_Komeiji;
import Thmod.Cards.UncommonCards.SeishiRoten;
import Thmod.Cards.UncommonCards.SelfTokamak;
import Thmod.Cards.UncommonCards.SenceofElegance;
import Thmod.Cards.UncommonCards.SenyouGoraku;
import Thmod.Cards.UncommonCards.ShyakuBuku;
import Thmod.Cards.UncommonCards.TenguNoTaiko;
import Thmod.Cards.UncommonCards.VampireKiss;
import Thmod.Cards.VanishingEverything;
import Thmod.Characters.KomeijiSatori;
import Thmod.Patches.AbstractCardEnum;
import Thmod.Patches.CharacterEnum;
import Thmod.Relics.KomeijisEye;
import Thmod.Relics.SpellCardsRule;
import basemod.BaseMod;
import basemod.DevConsole;
import basemod.IUIElement;
import basemod.ModLabeledToggleButton;
import basemod.ModPanel;
import basemod.interfaces.EditCardsSubscriber;
import basemod.interfaces.EditCharactersSubscriber;
import basemod.interfaces.EditKeywordsSubscriber;
import basemod.interfaces.EditRelicsSubscriber;
import basemod.interfaces.EditStringsSubscriber;
import basemod.interfaces.PostDungeonInitializeSubscriber;
import basemod.interfaces.PostInitializeSubscriber;
import basemod.interfaces.StartGameSubscriber;

import static basemod.DevConsole.logger;


@SpireInitializer
public class ThMod implements PostDungeonInitializeSubscriber, EditRelicsSubscriber, EditStringsSubscriber,PostInitializeSubscriber,EditKeywordsSubscriber,EditCharactersSubscriber,EditCardsSubscriber ,StartGameSubscriber {
    private static final String MODNAME = "Touhou Mod";
    private static final String AUTHOR = "hoykj";
    private static final String DESCRIPTION = "2018.04.14";
    public static boolean AliceOpen ;
    public static boolean SoundOpen ;
    public static boolean StartSelectOpen ;
    private float X;
    private float Y;
    private float IntervalY;
    private static final Color Komeiji = CardHelper.getColor(232, 123, 169);
    private static final Color SPCard = CardHelper.getColor(232, 123, 169);
    private static final Color ItemCard = CardHelper.getColor(232, 123, 169);
    private static final Color DeriveCard = CardHelper.getColor(232, 123, 169);
    public static TextureAtlas orbAtlas;
    public static ArrayList<String> fightids = new ArrayList<>();
    public static ArrayList<String> campids = new ArrayList<>();
    public static ArrayList<String> upcardids = new ArrayList<>();
    public static ArrayList<String> weathers = new ArrayList<>();
    public static HashMap<String,Integer> removemap = new HashMap<>();
    public static HashMap<String,Integer> upcardmap = new HashMap<>();
    public static HashMap<String,AbstractCard> removedcardids = new HashMap<>();

    public static String komeijiCardImage(final String id) {
        return "images/cards/komeiji/" + id + ".png";
    }

    public static String spellCardImage(final String id) {
        return "images/cards/spcards/" + id + ".png";
    }

    public static String itemCardImage(final String id) {
        return "images/cards/itemcards/" + id + ".png";
    }

    public static String deriveCardImage(final String id) {
        return "images/cards/derivecards/" + id + ".png";
    }

    public static String komeijiRelicImage(final String id) {
        return "images/relics/" + id + ".png";
    }
    public static String komeijiRelicOutlineImage(final String id) {
        return "images/relics/outline/" + id + ".png";
    }

    public static void initialize()  {
        DevConsole.logger.info("========================= 初始化ThMod所有数据 =========================");

        ThMod localThMod = new ThMod();

        campids.add("PerfectMaid");
        campids.add("VanishingEverything");
        campids.add("JyouchiJin");
        campids.add("KeiseiJin");
        campids.add("KinbakuJin");
        campids.add("Agarareta");
        campids.add("DochyakuKami");
        campids.add("Mishyaguji");
        campids.add("GroundStardust");
        campids.add("MajikuruSanhai");
        campids.add("KoKei");
        campids.add("KouPou");
        campids.add("KokorosuKi");
        campids.add("SeishiRoten");

        fightids.add("KeiseiJin");
        fightids.add("KinbakuJin");
        fightids.add("JyouchiJin");
        fightids.add("HagoromoMizu");
        fightids.add("RikonNoKama");
        fightids.add("Sabishigari");
        fightids.add("DamonLordCradle");
        fightids.add("NarrowSpark");
        fightids.add("SeishiRoten");
        fightids.add("KokorosuKi");
        fightids.add("VampireKiss");
        fightids.add("MusuNoYume");
        fightids.add("HenyouMirume");
        fightids.add("MissingPower");
        fightids.add("KouPou");
        fightids.add("KoKei");
        fightids.add("MajikuruSanhai");
        fightids.add("DemonsDinnerFork");
        fightids.add("SenceofElegance");
        fightids.add("MusouMyousyu");
        fightids.add("LunaDial");
        fightids.add("HisouTensoku");
        fightids.add("WumiGaWareru");
        fightids.add("TerribleSouvenir");

        upcardids.add("FuumaJin");
        upcardids.add("HappouKibaku");
        upcardids.add("HagoromoToki");
        upcardids.add("SeikonRyuuri");
        upcardids.add("MirenKamai");
        upcardids.add("DraculaCradle");
        upcardids.add("FinalSpark");
        upcardids.add("EasyMasterSpark");
        upcardids.add("EnshinRoten");
        upcardids.add("SakuraHirame");
        upcardids.add("Mireniamu");
        upcardids.add("MusuNoTegata");
        upcardids.add("RapurasuNoMa");
        upcardids.add("MissingPurplePower");
        upcardids.add("TaihouKen");
        upcardids.add("TaihouTsuigeki");
        upcardids.add("MoukoNaikei");
        upcardids.add("DeepEcologicalBomb");
        upcardids.add("HeartBreak");
        upcardids.add("SpeartheGungnir");
        upcardids.add("SenseofCherryBlossom");
        upcardids.add("MusouTensei");
        upcardids.add("SakuyaNoSekai");
        upcardids.add("TenkeiKisyou");
        upcardids.add("MoozeNoKiseki");
        upcardids.add("KyoufuSaimin");

        removemap.put("KeiseiJin",1);
        removemap.put("KinbakuJin",1);
        removemap.put("JyouchiJin",1);
        removemap.put("HagoromoMizu",2);
        removemap.put("RikonNoKama",3);
        removemap.put("Sabishigari",4);
        removemap.put("DamonLordCradle",5);
        removemap.put("NarrowSpark",6);
        removemap.put("SeishiRoten",7);
        removemap.put("KokorosuKi",8);
        removemap.put("VampireKiss",9);
        removemap.put("MusuNoYume",10);
        removemap.put("HenyouMirume",11);
        removemap.put("MissingPower",12);
        removemap.put("KouPou",13);
        removemap.put("KoKei",14);
        removemap.put("MajikuruSanhai",15);
        removemap.put("DemonsDinnerFork",16);
        removemap.put("SenceofElegance",17);
        removemap.put("MusouMyousyu",18);
        removemap.put("LunaDial",19);
        removemap.put("HisouTensoku",20);
        removemap.put("WumiGaWareru",21);
        removemap.put("TerribleSouvenir",22);

        upcardmap.put("FuumaJin",1);
        upcardmap.put("HappouKibaku",1);
        upcardmap.put("HagoromoToki",2);
        upcardmap.put("SeikonRyuuri",3);
        upcardmap.put("MirenKamai",4);
        upcardmap.put("DraculaCradle",5);
        upcardmap.put("FinalSpark",6);
        upcardmap.put("EasyMasterSpark",6);
        upcardmap.put("EnshinRoten",7);
        upcardmap.put("SakuraHirame",8);
        upcardmap.put("Mireniamu",9);
        upcardmap.put("MusuNoTegata",10);
        upcardmap.put("RapurasuNoMa",11);
        upcardmap.put("MissingPurplePower",12);
        upcardmap.put("TaihouKen",13);
        upcardmap.put("TaihouTsuigeki",13);
        upcardmap.put("MoukoNaikei",14);
        upcardmap.put("DeepEcologicalBomb",15);
        upcardmap.put("HeartBreak",16);
        upcardmap.put("SpeartheGungnir",16);
        upcardmap.put("SenseofCherryBlossom",17);
        upcardmap.put("MusouTensei",18);
        upcardmap.put("SakuyaNoSekai",19);
        upcardmap.put("TenkeiKisyou",20);
        upcardmap.put("MoozeNoKiseki",21);
        upcardmap.put("KyoufuSaimin",22);

        weathers.add("KaiSei");
        weathers.add("KiriSame");
        weathers.add("DonTen");
        weathers.add("SouTen");
        weathers.add("Haku");
        weathers.add("HanaGumo");
        weathers.add("NouMu");
        weathers.add("Yuki");
        weathers.add("TenkiYume");
        weathers.add("Soyuki");
        weathers.add("Fuuu");
        weathers.add("SeiRan");
        weathers.add("KawaGiri");
        weathers.add("TaiFuu");
        weathers.add("Nagi");
        weathers.add("DaiyamondoDasuto");
        weathers.add("Kousa");
        weathers.add("RetsuJitsu");
        weathers.add("Tsume");
        weathers.add("KyoKkou");

        try {
            final Properties defaults = new Properties();
            defaults.setProperty("AliceOpen", "true");
            defaults.setProperty("SoundOpen", "true");
            defaults.setProperty("StartSelectOpen", "true");
            final SpireConfig config = new SpireConfig("ThMod", "Common", defaults);
            ThMod.AliceOpen = config.getBool("AliceOpen");
            ThMod.SoundOpen = config.getBool("SoundOpen");
            ThMod.StartSelectOpen = config.getBool("StartSelectOpen");
        } catch (IOException e) {
            e.printStackTrace();
        }


        DevConsole.logger.info("=========================== 初始化ThMod成功 ===========================");
        logger.info("========================正在注入新卡片相关信息========================");

        BaseMod.addColor(AbstractCardEnum.Komeiji.toString(),
                Komeiji, Komeiji, Komeiji, Komeiji, Komeiji, Komeiji, Komeiji,
                "images/cardui/512/bg_attack_komeiji.png", "images/cardui/512/bg_skill_komeiji.png",
                "images/cardui/512/bg_power_komeiji.png", "images/cardui/512/card_komeiji_orb.png",
                "images/cardui/1024/bg_attack_komeiji.png", "images/cardui/1024/bg_skill_komeiji.png",
                "images/cardui/1024/bg_power_komeiji.png", "images/cardui/1024/card_komeiji_orb.png");

        BaseMod.addColor(AbstractCardEnum.SPCard.toString(),
                SPCard, SPCard, SPCard, SPCard, SPCard, SPCard, SPCard,
                "images/cardui/512/bg_attack_komeiji.png", "images/cardui/512/bg_skill_komeiji.png",
                "images/cardui/512/bg_power_komeiji.png", "images/cardui/512/card_komeiji_orb.png",
                "images/cardui/1024/bg_attack_komeiji.png", "images/cardui/1024/bg_skill_komeiji.png",
                "images/cardui/1024/bg_power_komeiji.png", "images/cardui/1024/card_komeiji_orb.png");

        BaseMod.addColor(AbstractCardEnum.ItemCard.toString(),
                ItemCard, ItemCard, ItemCard, ItemCard, ItemCard, ItemCard, ItemCard,
                "images/cardui/512/bg_attack_komeiji.png", "images/cardui/512/bg_skill_komeiji.png",
                "images/cardui/512/bg_power_komeiji.png", "images/cardui/512/card_komeiji_orb.png",
                "images/cardui/1024/bg_attack_komeiji.png", "images/cardui/1024/bg_skill_komeiji.png",
                "images/cardui/1024/bg_power_komeiji.png", "images/cardui/1024/card_komeiji_orb.png");

        BaseMod.addColor(AbstractCardEnum.DeriveCard.toString(),
                DeriveCard, DeriveCard, DeriveCard, DeriveCard, DeriveCard, DeriveCard, DeriveCard,
                "images/cardui/512/bg_attack_komeiji.png", "images/cardui/512/bg_skill_komeiji.png",
                "images/cardui/512/bg_power_komeiji.png", "images/cardui/512/card_komeiji_orb.png",
                "images/cardui/1024/bg_attack_komeiji.png", "images/cardui/1024/bg_skill_komeiji.png",
                "images/cardui/1024/bg_power_komeiji.png", "images/cardui/1024/card_komeiji_orb.png");



        logger.info("========================注入新卡片相关信息成功========================");
    }
    public ThMod()
    {
        DevConsole.logger.info("============================ 监听初始化事件 ============================");
        BaseMod.subscribe(this);

        this.X = 400.0f;
        this.Y = 800.0f;
        this.IntervalY = -50.0f;

        DevConsole.logger.info("========================================================================");
    }

    public void receiveStartGame() {
        final String filepath = "saves" + File.separator + "KomeijiSatori.autosave";
        final boolean fileExists = Gdx.files.local(filepath).exists();
        if (!fileExists) {
            DevConsole.logger.info("==========================第一次载入初始化==========================");
            try {
                Default();
            }
            catch (IOException e) {
                e.printStackTrace();
            }
            DevConsole.logger.info("==========================第一次载入初始化o了==========================");
        }
        DevConsole.logger.info("=========================数据载入=========================");
        try {
            final Properties defaults = new Properties();
            defaults.setProperty("PointPower", "0");
            final SpireConfig config = new SpireConfig("ThMod", "Common", defaults);
            SpellCardsRule.pointcount.clear();
            SpellCardsRule.pointcount.add(config.getInt("PointPower"));
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        DevConsole.logger.info("=========================数据载入也o了=========================");

    }

    public void receiveEditCharacters() {
        logger.info("========================正在注入Mod人物信息========================");

        logger.info("add " + CharacterEnum.KomeijiSatori.toString());

        BaseMod.addCharacter(
                KomeijiSatori.class, "古明地 觉", "CharacterName class string",
                AbstractCardEnum.Komeiji.toString(),"古明地 觉","images/ui/charSelect/komeijiButton.png", "images/ui/charSelect/komeijiPortrait.jpg",
                CharacterEnum.KomeijiSatori.toString());

        logger.info("========================注入Mod人物信息成功========================");
    }

    public void receiveEditRelics()
    {
        //BaseMod.addRelic(new WarGhost(), RelicType.SHARED);
    }

    public void receiveEditCards() {
        logger.info("=========================正在加载新的卡牌内容=========================");

        BaseMod.addCard(new Strike_Komeiji());
        BaseMod.addCard(new Defend_Komeiji());
        BaseMod.addCard(new Dash_Komeiji());
        BaseMod.addCard(new VanishingEverything());
        BaseMod.addCard(new PerfectMaid());
        BaseMod.addCard(new HagoromoMizu());
        BaseMod.addCard(new KeiseiJin());
        BaseMod.addCard(new KinbakuJin());
        BaseMod.addCard(new JyouchiJin());
//        BaseMod.addCard(new KochyouYume());
        BaseMod.addCard(new Agarareta());
        BaseMod.addCard(new DemonLordCradle());
        BaseMod.addCard(new Demotivation());
        BaseMod.addCard(new DochyakuKami());
        BaseMod.addCard(new HagoromoMizu());
        BaseMod.addCard(new InscribeRedSoul());
        BaseMod.addCard(new MagicStarsSword());
        BaseMod.addCard(new MakuraSeki());
        BaseMod.addCard(new Melting());
        BaseMod.addCard(new Sabishigari());
        BaseMod.addCard(new Mishyaguji());
        BaseMod.addCard(new SuitokuNoKyoryu());

        BaseMod.addCard(new DemonsDinnerFork());
        BaseMod.addCard(new FreezeToughMe());
        BaseMod.addCard(new GasuOrimono());
        BaseMod.addCard(new GroundStardust());
        BaseMod.addCard(new HenyouMirume());
        BaseMod.addCard(new HisouNoKen());
        BaseMod.addCard(new KimairaNoYoku());
        BaseMod.addCard(new KoKei());
        BaseMod.addCard(new KokorosuKi());
        BaseMod.addCard(new KouPou());
        BaseMod.addCard(new MajikuruSanhai());
        BaseMod.addCard(new MissingPower());
        BaseMod.addCard(new MusuNoYume());
        BaseMod.addCard(new NarrowSpark());
        BaseMod.addCard(new RoshinSou());
        BaseMod.addCard(new SatsujinDooru());
        BaseMod.addCard(new SeishiRoten());
        BaseMod.addCard(new SelfTokamak());
        BaseMod.addCard(new SenceofElegance());
        BaseMod.addCard(new SenyouGoraku());
        BaseMod.addCard(new ShyakuBuku());
        BaseMod.addCard(new TenguNoTaiko());
        BaseMod.addCard(new VampireKiss());

        BaseMod.addCard(new AbyssNova());
        BaseMod.addCard(new EverywhereHibernate());
        BaseMod.addCard(new HagoromoKu());
        BaseMod.addCard(new HisouTensoku());
        BaseMod.addCard(new IceTornado());
        BaseMod.addCard(new JigokuNoTaiyou());
        BaseMod.addCard(new LunaDial());
        BaseMod.addCard(new LunaticRedEyes());
        BaseMod.addCard(new MunenMusou());
        BaseMod.addCard(new MusouMyousyu());
        BaseMod.addCard(new TenguhouSokujitsuken());
        BaseMod.addCard(new TerribleSouvenir());
        BaseMod.addCard(new WumiGaWareru());
        BaseMod.addCard(new YuumeiNoKurin());

        BaseMod.addCard(new ReiGeki());
        BaseMod.addCard(new MajikkuPosyun());
        BaseMod.addCard(new SutoppuWocchi());
        BaseMod.addCard(new SaSen());
        BaseMod.addCard(new ByoukiHeiyu());
        BaseMod.addCard(new FusyokuKusuri());
        BaseMod.addCard(new HisouNoKenItem());
        BaseMod.addCard(new IbukiHisyaku());
        BaseMod.addCard(new Namazu());
        BaseMod.addCard(new RyuuSei());
        BaseMod.addCard(new SanbutsuTenmizu());
        BaseMod.addCard(new SeigyoBou());

        BaseMod.addCard(new BurariHaieki());
        BaseMod.addCard(new DaiesanShikkaiKoroshi());
        BaseMod.addCard(new DeepEcologicalBomb());
        BaseMod.addCard(new DraculaCradle());
        BaseMod.addCard(new EasyMasterSpark());
        BaseMod.addCard(new EnshinRoten());
        BaseMod.addCard(new FinalSpark());
        BaseMod.addCard(new FusekiShinmei());
        BaseMod.addCard(new FuumaJin());
        BaseMod.addCard(new GensouFuubi());
        BaseMod.addCard(new HagoromoToki());
        BaseMod.addCard(new HangonChyou(0));
        BaseMod.addCard(new HappouKibaku());
        BaseMod.addCard(new HeartBreak());
        BaseMod.addCard(new Kamaitachi());
        BaseMod.addCard(new KokushiMusou());
        BaseMod.addCard(new KyoufuSaimin());
        BaseMod.addCard(new Mireniamu());
        BaseMod.addCard(new MirenKamai());
        BaseMod.addCard(new MissingPurplePower());
        BaseMod.addCard(new MoozeNoKiseki());
        BaseMod.addCard(new MoukoNaikei());
        BaseMod.addCard(new MusouTensei());
        BaseMod.addCard(new MusuNoTegata());
        BaseMod.addCard(new RapurasuNoMa());
        BaseMod.addCard(new RokkonShyoujyou());
        BaseMod.addCard(new SakuraHirame());
        BaseMod.addCard(new SakuyaNoSekai());
        BaseMod.addCard(new SeikonRyuuri());
        BaseMod.addCard(new SenseofCherryBlossom(0));
        BaseMod.addCard(new SpeartheGungnir());
        BaseMod.addCard(new TaihouKen());
        BaseMod.addCard(new TaihouTsuigeki());
        BaseMod.addCard(new TenkeiKisyou());
        BaseMod.addCard(new YomeiIkubaku());

        if(ThMod.AliceOpen){
            BaseMod.addCard(new NingyouSousou());
        }

        logger.info("=========================加载新的卡牌内容成功=========================");
    }

    private void CreatePanel() throws IOException {
        final SpireConfig spireConfig = new SpireConfig("ThMod", "Common");
        final ModPanel settingsPanel = new ModPanel();
     //   final ModPanel settingsPanel = new ModPanel();
        settingsPanel.addButton(this.X, this.Y + 5*this.IntervalY, me -> {
            spireConfig.setBool("AliceOpen", ThMod.AliceOpen = !ThMod.AliceOpen);
            try {
                spireConfig.save();
            }
            catch (IOException e) {
                e.printStackTrace();
            }
            return;
        });
//        final ModLabeledToggleButton AliceOpen = new ModLabeledToggleButton("启用爱丽丝卡组", this.X, this.Y + 4*this.IntervalY , Settings.CREAM_COLOR, FontHelper.charDescFont,ThMod.AliceOpen , settingsPanel, label -> {}, button -> {
//            spireConfig.setBool("AliceOpen", ThMod.AliceOpen = button.enabled);
//            CardCrawlGame.mainMenuScreen.optionPanel.effects.clear();
//            CardCrawlGame.mainMenuScreen.optionPanel.effects.add(new RestartForChangesEffect());
//
//            try {
//                spireConfig.save();
//            }
//            catch (IOException e) {
//                e.printStackTrace();
//            }
//            return;
//        });
//        settingsPanel.addUIElement((IUIElement)AliceOpen);

        final ModLabeledToggleButton SoundOpen = new ModLabeledToggleButton("mod自带音效", this.X, this.Y + 6*this.IntervalY , Settings.CREAM_COLOR, FontHelper.charDescFont,ThMod.SoundOpen , settingsPanel, label -> {}, button -> {
            spireConfig.setBool("SoundOpen", ThMod.SoundOpen = button.enabled);
            CardCrawlGame.mainMenuScreen.optionPanel.effects.clear();
            CardCrawlGame.mainMenuScreen.optionPanel.effects.add(new RestartForChangesEffect());

            try {
                spireConfig.save();
            }
            catch (IOException e) {
                e.printStackTrace();
            }
            return;
        });
        settingsPanel.addUIElement((IUIElement)SoundOpen);

        final ModLabeledToggleButton StartSelectOpen = new ModLabeledToggleButton("回合开始时选择符卡", this.X, this.Y + 7*this.IntervalY , Settings.CREAM_COLOR, FontHelper.charDescFont,ThMod.SoundOpen , settingsPanel, label -> {}, button -> {
            spireConfig.setBool("StartSelectOpen", ThMod.StartSelectOpen = button.enabled);
            CardCrawlGame.mainMenuScreen.optionPanel.effects.clear();
            CardCrawlGame.mainMenuScreen.optionPanel.effects.add(new RestartForChangesEffect());

            try {
                spireConfig.save();
            }
            catch (IOException e) {
                e.printStackTrace();
            }
            return;
        });
        settingsPanel.addUIElement((IUIElement)StartSelectOpen);

        Texture badgeTexture = new Texture(Gdx.files.internal("images/ThMod.png"));
        BaseMod.registerModBadge(badgeTexture, MODNAME, AUTHOR, DESCRIPTION, settingsPanel);
        settingsPanel.addLabel("设置", this.X, this.Y + 1*this.IntervalY , (me) -> { });
        settingsPanel.addLabel("点击按钮切换扩展卡组，重启后生效", this.X, this.Y + 2*this.IntervalY , (me) -> { });
        settingsPanel.addLabel("", 525.0f, this.Y + 4*this.IntervalY, me -> {
            if (ThMod.AliceOpen) {
                me.text = "启用爱丽丝卡组(还不能用)";
            }
            else {
                me.text = "启用帕秋莉卡组(还不能用)";
            }
            return;
        });
        settingsPanel.addLabel("本mod和其它部分mod可能存在部分冲突", this.X, this.Y + 9*this.IntervalY, (me) -> { });
        settingsPanel.addLabel("目前进度:", 1100f, this.Y + 2*this.IntervalY , (me) -> { });
        settingsPanel.addLabel("卡组:通用部分完成", 1100f, this.Y + 3*this.IntervalY , (me) -> { });
        settingsPanel.addLabel("遗物:做了个头", 1100f, this.Y + 4*this.IntervalY , (me) -> { });
        settingsPanel.addLabel("美工:还没开始", 1100f, this.Y + 5*this.IntervalY , (me) -> { });
        settingsPanel.addLabel("debug:做了一丢丢", 1100f, this.Y + 6*this.IntervalY , (me) -> { });
        settingsPanel.addLabel("特效:几乎没做", 1100f, this.Y + 7*this.IntervalY , (me) -> { });
        //settingsPanel.addLabel("设计:hoykj  编程:hoykj  绘图:hoykj", 400.0f, 500.0f, (me) -> { });
    }
    public void receivePostInitialize() {
        // Mod badge
        try {
            this.CreatePanel();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        // Add relics
        RelicLibrary.add(new KomeijisEye());
        RelicLibrary.add(new SpellCardsRule());
    }
    public void receiveEditStrings()
    {
        DevConsole.logger.info("========================= 正在加载文本信息 =========================");

        String cardStrings = Gdx.files.internal("localization/Cards.json").readString(String.valueOf(StandardCharsets.UTF_8));
        BaseMod.loadCustomStrings(CardStrings.class, cardStrings);
        String relicStrings = Gdx.files.internal("localization/Relics.json").readString(String.valueOf(StandardCharsets.UTF_8));
        BaseMod.loadCustomStrings(RelicStrings.class, relicStrings);
        String powerStrings = Gdx.files.internal("localization/Power.json").readString(String.valueOf(StandardCharsets.UTF_8));
        BaseMod.loadCustomStrings(PowerStrings.class, powerStrings);
        String uiStrings = Gdx.files.internal("localization/UI.json").readString(String.valueOf(StandardCharsets.UTF_8));
        BaseMod.loadCustomStrings(UIStrings.class, uiStrings);

        DevConsole.logger.info("========================================================================");
    }
    public void receivePostDungeonInitialize()
    {
        //if (!(AbstractDungeon.player.hasRelic("BlinkDagger")))
            //   new BlinkDagger().instantObtain();

    }
    public void receiveEditKeywords()
    {
        DevConsole.logger.info("========================= 正在加载特性文本信息 =========================");
        BaseMod.addKeyword(new String[]{"擦弹","擦弹"}, "闪避伤害");
        BaseMod.addKeyword(new String[]{"符卡规则","符卡规则"}, "1.每个回合开始时,你将根据你的 #rp 点来获取SP卡. NL 2.获得的SP卡和你的手牌有关. NL 3.所有符卡具有 #y消耗 与 #y虚无 . NL 4.剩下的就靠你自己来摸索吧!");
        BaseMod.addKeyword(new String[]{"联想","联想"}, "这张卡不能被升级,但是可以在篝火处转换为另外的卡");
        BaseMod.addKeyword(new String[]{"替换","替换"}, "这种卡将会替换你手中的一张卡,在消耗后恢复.");
        BaseMod.addKeyword(new String[]{"回响","回响"}, "这张卡在使用后会将一张复制加入你的手牌");
        BaseMod.addKeyword(new String[]{"蓄力","蓄力"}, "这张卡在使用后不会立刻触发效果,而是由你选择触发");
        BaseMod.addKeyword(new String[]{"固定","固定"}, "不受任何加成");
        BaseMod.addKeyword(new String[]{"紧缚灵","紧缚灵"}, "在它受到伤害时,每只紧缚灵会对它造成10点伤害并消失");
        BaseMod.addKeyword(new String[]{"天气","天气"}, "天气将为你提供额外效果");
    }

    public static void SavePointPower() throws IOException {
        final SpireConfig config = new SpireConfig("ThMod", "Common");
        config.setInt("PointPower", (int) SpellCardsRule.pointcount.get(0));
        config.save();
    }

    public static void Default() throws IOException {
        final SpireConfig config = new SpireConfig("ThMod", "Common");
        config.setInt("PointPower", 0);
        config.save();
    }

    static {
        ThMod.SoundOpen = true;
        ThMod.AliceOpen = true;
        ThMod.StartSelectOpen = true;
    }

}