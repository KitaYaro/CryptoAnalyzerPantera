package com.javarush.matsarskaia;

public class Alphabet {
    private static final char[] ALPHABET = {'а','б','в','г','д','е','ё','ж','з','и','й','к','л','м','н','о','п',
                                                'р','с','т','у', 'ф','х','ц','ч','ш','щ','ъ','ы','ь','э','ю','я',
                                                    '.',',','"',':',';','!','?','\'',' ','-','_',
                                                        '0','1','2','3','4','5','6','7','8','9'};

    public static char[] getAlphabet(){
        return ALPHABET;
    }
}
