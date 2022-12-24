# @param {String} s
# @return {Boolean}
def is_valid(s)
  stack = []

  for i in 0..s.length - 1
      if s[i] == '(' || s[i] == '{' || s[i] == '['
          stack << s[i]
      elsif !stack.empty? && s[i] == '}' && stack.last == '{'
          stack.pop
      elsif !stack.empty? && s[i] == ']' && stack.last == '['
          stack.pop
      elsif !stack.empty? && s[i] == ')' && stack.last == '('
          stack.pop
      else
          return false
      end
  end

  stack.empty?
end
