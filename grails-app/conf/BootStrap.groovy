class BootStrap {

    def init = { servletContext ->
        println "        _.._..,_,_\n" +
                "        (          )\n" +
                "         ]~,\"-.-~~[\n" +
                "       .=])' (;  ([\n" +
                "       | ]:: '    [\n" +
                "       '=]): .)  ([\n" +
                "         |:: '    |\n" +
                "          ~~----~~\n" +
                "ESSEARCH------STARTING"
        println"::::::|.:::::|.:::::|                    :|   \n" +
                ":::>   `:::::>`:::::>:~~/ .::\\ :::| .::/ :::| \n" +
                "::::::|,::::/ ,::::/ :::, `::| :|   `::\\ :|:| \n" +
                "                                              "
    }
    def destroy = {
        println "ESSEARCH------STOPPING"
    }
}
