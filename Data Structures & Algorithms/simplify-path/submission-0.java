class Solution {
    public String simplifyPath(String path) {
        String[] arr = path.split("/");
        Stack<String> stack = new Stack<>();

        for(String s : arr) {
            if(s.equals(".") || s.isEmpty()){
                continue;
            } else if(s.equals("..")){
                if(!stack.isEmpty()){
                    stack.pop();
                }
            } else {
                stack.push(s);
            }
        }

        if(stack.isEmpty()){
            return "/";
        }

        StringBuilder res = new StringBuilder();
        while(!stack.isEmpty()){
            res.insert(0, stack.pop()).insert(0, "/");
        }

        return res.toString();
    }
}