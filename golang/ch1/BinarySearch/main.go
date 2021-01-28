package main

import (
	"fmt"
	"math/rand"
	"sort"
)

func IndexOf(data []int, key int) int {
	lo := 0
	hi := len(data) - 1
	for lo <= hi {
		mid := lo + (hi-lo)/2
		if key < data[mid] {
			hi = mid - 1
		} else if key > data[mid] {
			lo = mid + 1
		} else {
			return mid
		}
	}
	return -1
}

func main() {
	data := make([]int, 10)
	for i := 0; i < 10; i++ {
		data[i] = rand.Intn(200)
	}
	sort.Slice(data, func(x, y int) bool {
		return data[x] < data[y]
	})
	fmt.Println(data)
	fmt.Println(IndexOf(data, 87))
}
