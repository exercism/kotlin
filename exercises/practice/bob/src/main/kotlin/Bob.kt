object Bob {
    fun hey(input: String): String {
        //TODO("Implement the function to complete the task")
    
        var response = ""
    
        if (input.last() == '?'){
            response = "Sure."
        }
        else {
            for (elt in input){
                if (elt.isUpperCase()) {
                    response = "Whoa, chill out!"
                } else if(elt.isUpperCase() && input.last() == '?'){
                    response = "Calm down, I know what I'm doing!"
                } else if (input.isEmpty() || input.isBlank()) {
                    response = "Fine. Be that way!"
                } else {
                    response = "Whatever"
                }
            }
    
        }
        return response
    }
}
