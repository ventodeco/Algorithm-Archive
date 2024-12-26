impl Solution {
    pub fn remove_duplicates(nums: &mut Vec<i32>) -> i32 {

        if nums.len() as i32 <= 1 {
            return nums.len() as i32;
        }

        let mut index : usize = 0;

        for i in 1..nums.len() {
            if nums[index] != nums[i] {
                index += 1;
                nums[index] = nums[i];
                continue;
            }
        }

        index += 1;
        nums.truncate(index);

        index as i32
    }
}