package jp.pokemonms.form;

import java.util.ArrayList;
import java.util.List;

import jp.pokemonms.model.constant.EggGroupType;
import jp.pokemonms.model.constant.ElementType;

/**
 * 図鑑フォーム 管理者のみ利用
 *
 * @author Sinmetal
 *
 */
public class PokemonForm {

    /** 全国図鑑ID */
    private Integer worldGuideNo;

    /** ポケモン名 */
    private String pokemonName;

    /** タイプ1 */
    private ElementType elementType1st;

    /** タイプ2 */
    private ElementType elementType2nd;

    /** 種族値H */
    private Integer breedH;

    /** 種族値A */
    private Integer breedA;

    /** 種族値B */
    private Integer breedB;

    /** 種族値C */
    private Integer breedC;

    /** 種族値D */
    private Integer breedD;

    /** 種族値S */
    private Integer breedS;

    /** タマゴグループ1 */
    private EggGroupType eggGroupType1st;

    /** タマゴグループ2 */
    private EggGroupType eggGroupType2nd;

    /** 特性1 */
    private String abilityName1st;

    /** 特性1が夢特性かどうか */
    private Boolean isAbilityDream1st;

    /** 特性2 */
    private String abilityName2nd;

    /** 特性2が夢特性かどうか */
    private Boolean isAbilityDream2nd;

    /** 特性3 */
    private String abilityName3rd;

    /** 特性3が夢特性かどうか */
    private Boolean isAbilityDream3rd;

    /**
     * @return worldGuideNo
     */
    public Integer getWorldGuideNo() {
        return worldGuideNo;
    }

    /**
     * @param worldGuideNo
     *            セットする worldGuideNo
     */
    public void setWorldGuideNo(Integer worldGuideNo) {
        this.worldGuideNo = worldGuideNo;
    }

    /**
     * @return pokemonName
     */
    public String getPokemonName() {
        return pokemonName;
    }

    /**
     * @param pokemonName
     *            セットする pokemonName
     */
    public void setPokemonName(String pokemonName) {
        this.pokemonName = pokemonName;
    }

    /**
     * @return elementType1st
     */
    public ElementType getElementType1st() {
        return elementType1st;
    }

    /**
     * @param elementType1st
     *            セットする elementType1st
     */
    public void setElementType1st(ElementType elementType1st) {
        this.elementType1st = elementType1st;
    }

    /**
     * @return elementType2nd
     */
    public ElementType getElementType2nd() {
        return elementType2nd;
    }

    /**
     * @param elementType2nd
     *            セットする elementType2nd
     */
    public void setElementType2nd(ElementType elementType2nd) {
        this.elementType2nd = elementType2nd;
    }

    /**
     * @return breedH
     */
    public Integer getBreedH() {
        return breedH;
    }

    /**
     * @param breedH
     *            セットする breedH
     */
    public void setBreedH(Integer breedH) {
        this.breedH = breedH;
    }

    /**
     * @return breedA
     */
    public Integer getBreedA() {
        return breedA;
    }

    /**
     * @param breedA
     *            セットする breedA
     */
    public void setBreedA(Integer breedA) {
        this.breedA = breedA;
    }

    /**
     * @return breedB
     */
    public Integer getBreedB() {
        return breedB;
    }

    /**
     * @param breedB
     *            セットする breedB
     */
    public void setBreedB(Integer breedB) {
        this.breedB = breedB;
    }

    /**
     * @return breedC
     */
    public Integer getBreedC() {
        return breedC;
    }

    /**
     * @param breedC
     *            セットする breedC
     */
    public void setBreedC(Integer breedC) {
        this.breedC = breedC;
    }

    /**
     * @return breedD
     */
    public Integer getBreedD() {
        return breedD;
    }

    /**
     * @param breedD
     *            セットする breedD
     */
    public void setBreedD(Integer breedD) {
        this.breedD = breedD;
    }

    /**
     * @return breedS
     */
    public Integer getBreedS() {
        return breedS;
    }

    /**
     * @param breedS
     *            セットする breedS
     */
    public void setBreedS(Integer breedS) {
        this.breedS = breedS;
    }

    /**
     * @return eggGroupType1st
     */
    public EggGroupType getEggGroupType1st() {
        return eggGroupType1st;
    }

    /**
     * @param eggGroupType1st
     *            セットする eggGroupType1st
     */
    public void setEggGroupType1st(EggGroupType eggGroupType1st) {
        this.eggGroupType1st = eggGroupType1st;
    }

    /**
     * @return eggGroupType2nd
     */
    public EggGroupType getEggGroupType2nd() {
        return eggGroupType2nd;
    }

    /**
     * @param eggGroupType2nd
     *            セットする eggGroupType2nd
     */
    public void setEggGroupType2nd(EggGroupType eggGroupType2nd) {
        this.eggGroupType2nd = eggGroupType2nd;
    }

    /**
     * @return abilityName1st
     */
    public String getAbilityName1st() {
        return abilityName1st;
    }

    /**
     * @param abilityName1st
     *            セットする abilityName1st
     */
    public void setAbilityName1st(String abilityName1st) {
        this.abilityName1st = abilityName1st;
    }

    /**
     * @return isAbilityDream1st
     */
    public Boolean getIsAbilityDream1st() {
        return isAbilityDream1st;
    }

    /**
     * @param isAbilityDream1st
     *            セットする isAbilityDream1st
     */
    public void setIsAbilityDream1st(Boolean isAbilityDream1st) {
        this.isAbilityDream1st = isAbilityDream1st;
    }

    /**
     * @return abilityName2nd
     */
    public String getAbilityName2nd() {
        return abilityName2nd;
    }

    /**
     * @param abilityName2nd
     *            セットする abilityName2nd
     */
    public void setAbilityName2nd(String abilityName2nd) {
        this.abilityName2nd = abilityName2nd;
    }

    /**
     * @return isAbilityDream2nd
     */
    public Boolean getIsAbilityDream2nd() {
        return isAbilityDream2nd;
    }

    /**
     * @param isAbilityDream2nd
     *            セットする isAbilityDream2nd
     */
    public void setIsAbilityDream2nd(Boolean isAbilityDream2nd) {
        this.isAbilityDream2nd = isAbilityDream2nd;
    }

    /**
     * @return abilityName3rd
     */
    public String getAbilityName3rd() {
        return abilityName3rd;
    }

    /**
     * @param abilityName3rd
     *            セットする abilityName3rd
     */
    public void setAbilityName3rd(String abilityName3rd) {
        this.abilityName3rd = abilityName3rd;
    }

    /**
     * @return isAbilityDream3rd
     */
    public Boolean getIsAbilityDream3rd() {
        return isAbilityDream3rd;
    }

    /**
     * @param isAbilityDream3rd
     *            セットする isAbilityDream3rd
     */
    public void setIsAbilityDream3rd(Boolean isAbilityDream3rd) {
        this.isAbilityDream3rd = isAbilityDream3rd;
    }

    /**
     * インスタンス一覧を返す
     *
     * @param data
     *            固定フォーマットのデータ列
     * @return
     */
    public static List<PokemonForm> getInstances(String input) {
        final String LINE_SEPARATOR = "\r\n";
        final String COLUMN_SEPARATOR = ",";

        String[] lines = input.split(LINE_SEPARATOR);

        ArrayList<PokemonForm> result = new ArrayList<PokemonForm>();
        for (String line : lines) {
            String[] columns = line.split(COLUMN_SEPARATOR);
            result.add(PokemonForm.buildInstance(columns));
        }

        return result;
    }

    /**
     * インスタンス取得
     *
     * @param data
     * @return
     */
    protected static PokemonForm buildInstance(String data[]) {
        PokemonForm form = new PokemonForm();
        form.worldGuideNo = Integer.parseInt(data[0]);
        form.pokemonName = data[1];
        form.elementType1st = ElementType.parseOrNull(data[2]);
        form.elementType2nd = ElementType.parseOrNull(data[3]);
        form.breedH = Integer.parseInt(data[4]);
        form.breedA = Integer.parseInt(data[5]);
        form.breedB = Integer.parseInt(data[6]);
        form.breedC = Integer.parseInt(data[7]);
        form.breedD = Integer.parseInt(data[8]);
        form.breedS = Integer.parseInt(data[9]);
        form.eggGroupType1st = EggGroupType.parseOrNull(data[10]);
        form.eggGroupType2nd = EggGroupType.parseOrNull(data[11]);
        form.abilityName1st = data[12];
        form.isAbilityDream1st = false;

        form.abilityName2nd = "";
        form.isAbilityDream2nd = false;
        // ポケモンによっては、2つ目の特性は無いので、回避
        if (data.length > 13) {
            form.abilityName2nd = data[13];
            if (isDreamAbility(form.abilityName2nd)) {
                form.abilityName2nd =
                    buildeAbilityName4Dream(form.abilityName2nd);
                form.isAbilityDream2nd = true;
            }
        }

        form.abilityName3rd = "";
        form.isAbilityDream3rd = false;
        // ポケモンによっては、3つ目の特性は無いので、回避
        if (data.length > 14) {
            form.abilityName3rd = data[14];
            if (isDreamAbility(form.abilityName3rd)) {
                form.abilityName3rd =
                    buildeAbilityName4Dream(form.abilityName3rd);
                form.isAbilityDream3rd = true;
            }
        }

        return form;
    }

    /**
     * 特性が夢特性か
     *
     * @param abilityName
     * @return
     */
    protected static boolean isDreamAbility(String abilityName) {
        return (abilityName.indexOf("*") > -1);
    }

    /**
     * 夢特性の場合の特性名取得
     *
     * @param abilityName
     * @return
     */
    protected static String buildeAbilityName4Dream(String abilityName) {
        return abilityName.substring(1, abilityName.length());
    }
}
