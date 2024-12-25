impl Solution {
    pub fn is_palindrome(x: i32) -> bool {
        let conversion : String = x.to_string();

        let mut left : usize = 0;
        let mut right : usize = conversion.len() - 1;

        while left < right {
            if conversion.chars().nth(left) != conversion.chars().nth(right) {
                return false;
            }

            left += 1;
            right -= 1;
        }

        true
    }
}