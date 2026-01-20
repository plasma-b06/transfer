function isOperator(char) {
  return ['+', '-', '*', '/', '^'].includes(char);
}

function prefixToPostfix(prefix) {
  const stack = [];
  // Reverse the prefix expression
  const reversed = prefix.split('').reverse();

  for (const char of reversed) {
    if (isOperator(char)) {
      const op1 = stack.pop();
      const op2 = stack.pop();
      const expr = op1 + op2 + char;
      stack.push(expr);
    } else {
      stack.push(char);
    }
  }

  return stack.pop();
}

// Example usage
const prefixExpr = "*+AB-CD";
const postfixExpr = prefixToPostfix(prefixExpr);
console.log("Postfix:", postfixExpr); // Output: AB+CD-*
