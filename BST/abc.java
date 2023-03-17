public static boolean isOperator(char ch){
    if(ch=='+' || ch=='-'|| ch=='*' || ch=='/' || ch=='^'){
        return true;
    }
    return false;
}
public static Node expressionTree(String postfix){
    Stack<Node> st = new Stack<Node>();
    Node t1,t2,temp;

    for(int i=0;i<postfix.length();i++){
        if(!isOperator(postfix.charAt(i))){
            temp = new Node(postfix.charAt(i));
            st.push(temp);
        }
        else{
            temp = new Node(postfix.charAt(i));

            t1 = st.pop();
            t2 = st.pop();

            temp.left = t2;
            temp.right = t1;

            st.push(temp);
        }

    }
    temp = st.pop();
    return temp;
}