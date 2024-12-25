impl Solution {
    pub fn roman_to_int(s: String) -> i32 {
        let mut res : i32 = 0;
        let mut i : usize = 0;

        while i < s.len() {

            let current_num : i32 = Self::roman_conversion(s.chars().nth(i).unwrap());

            if (
                i + 1 < s.len() && 
                current_num < Self::roman_conversion(s.chars().nth(i + 1).unwrap())
            ) {
                let next_num : i32 = Self::roman_conversion(s.chars().nth(i + 1).unwrap());
                res += next_num - current_num;
                println!("res: {:?}", res);
                println!("current_num: {:?}", current_num);
                println!("next_num: {:?}", next_num);
                i += 1;
            } else {
                res += Self::roman_conversion(s.chars().nth(i).unwrap());
            }

            i += 1;
        }

        res
    }

    fn roman_conversion(s: char) -> i32 {
        match s {
            'I' => 1,
            'V' => 5,
            'X' => 10,
            'L' => 50,
            'C' => 100,
            'D' => 500,
            'M' => 1000,
            _ => panic!("Invalid Roman Char"),
        }
    }
}