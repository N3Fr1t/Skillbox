public class Loader {
    public static void main(String[] args) {
        String text = "You say you're affiliated with murderers, killers (ayy)\n" +
                "The people you run with are thuggin' (gang)\n" +
                "But you're just a wanna be gunner (gang)\n" +
                "Like you was gonna do somethin'\n" +
                "Actin' like you catchin' bodies (ayy)\n" +
                "And you got juice, lil' youngin', you're buggin'\n" +
                "You ain't never even been charged in connection with battery\n" +
                "Bitch, you ain't plugged into nothin'\n" +
                "Rap God spit lyrical bullets (boom)\n" +
                "And gats cock, your partners better tool up\n" +
                "This has not to do with muscular\n" +
                "But have guns for sure, you better put a\n" +
                "Strap on, other words if you're a Gunner\n" +
                "Roll up with your (gang)\n" +
                "You're gon' need a arsenal\n" +
                "'Cause this bar is over your head";

        text = text.replaceAll("[-.?!')(,:]", "");

        for (int i = 0; i < text.length(); i++) {
            text = text.replaceAll(" ", "\n");
        }

        System.out.println(text);
    }
}
