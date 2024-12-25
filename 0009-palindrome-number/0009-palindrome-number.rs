impl Solution {
    pub fn is_palindrome(x: i32) -> bool {
        let conversion : String = x.to_string();

        let mut left : usize = 0;
        let mut right : usize = conversion.len() - 1;

        while left < right {
            if conversion.chars().nth(left).unwrap() != conversion.chars().nth(right).unwrap() {
                return false;
            }

            left += 1;
            right -= 1;
        }

        true
    }
}