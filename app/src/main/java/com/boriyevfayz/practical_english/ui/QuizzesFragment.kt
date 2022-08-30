package com.boriyevfayz.practical_english.ui

import android.graphics.Color
import android.os.Bundle
import android.os.Handler
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.boriyevfayz.practical_english.MainViewModel
import com.boriyevfayz.practical_english.Quizzes
import com.boriyevfayz.practical_english.R
import com.boriyevfayz.practical_english.databinding.FragmentQuizzesBinding
import kotlin.random.Random

class QuizzesFragment : Fragment() {
    private lateinit var _binding: FragmentQuizzesBinding
    private val mBinding get() = _binding

    private lateinit var viewModel: MainViewModel

    private lateinit var quizzes: ArrayList<Quizzes>

    private var indexQuiz: Int? = null

    private var quizList: ArrayList<Quizzes>? = null

    private var variant1: String? = null
    private var variant2: String? = null
    private var variant3: String? = null
    private var variant4: String? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentQuizzesBinding.inflate(layoutInflater, container, false)
        return mBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        quizList = (requireActivity() as MainActivity).quizList

        quizzes = getShuffledQuestions()

        viewModel = ViewModelProvider(requireActivity())[MainViewModel::class.java]

        viewModel.mQuizzesList.observe(viewLifecycleOwner) {
            quizList = it as ArrayList<Quizzes>
        }
        viewModel.mCurrentQuestion.observe(viewLifecycleOwner) { currentQuestionNumber ->
            if (currentQuestionNumber > 10) {
                mBinding.clTest.visibility = View.GONE
                mBinding.clResult.visibility = View.VISIBLE
                mBinding.tvResult.text =
                    getString(R.string.text_quiz, viewModel.mRightAnswerCount.value.toString())

                mBinding.cvRestart.setOnClickListener {
                    viewModel.setDefaultValues()
                    mBinding.clTest.visibility = View.VISIBLE
                    mBinding.clResult.visibility = View.GONE
                }

                mBinding.cvBackToMenu.setOnClickListener {
                    viewModel.setDefaultValues()
                    requireActivity().supportFragmentManager.beginTransaction()
                        .replace(R.id.main_container, HomeFragment()).commit()
                }
            } else {
                indexQuiz = currentQuestionNumber - 1

                generateVariant()

                openedAnswer()

                defaultColor()

                variantRandom()

                mBinding.tvProsses.text =
                    getString(R.string.text_quiz, currentQuestionNumber.toString())
                mBinding.tvNumbQuiz.text =
                    getString(R.string.text_numb_quiz, currentQuestionNumber.toString())
                mBinding.tvQuiz.text = quizzes[indexQuiz!!].question
                mBinding.pbProsses.progress = currentQuestionNumber
                mBinding.cvVar1.setOnClickListener {

                    defaultColor()

                    mBinding.cvVar1.setCardBackgroundColor(Color.YELLOW)
                    mBinding.cvAnswer.setOnClickListener {
                        answer(mBinding.tvVar1.text.toString(), 1)
                    }
                }
                mBinding.cvVar2.setOnClickListener {

                    defaultColor()

                    mBinding.cvVar2.setCardBackgroundColor(Color.YELLOW)
                    mBinding.cvAnswer.setOnClickListener {
                        answer(mBinding.tvVar2.text.toString(), 2)
                    }
                }
                mBinding.cvVar3.setOnClickListener {

                    defaultColor()

                    mBinding.cvVar3.setCardBackgroundColor(Color.YELLOW)
                    mBinding.cvAnswer.setOnClickListener {
                        answer(mBinding.tvVar3.text.toString(), 3)
                    }
                }
                mBinding.cvVar4.setOnClickListener {

                    defaultColor()

                    mBinding.cvVar4.setCardBackgroundColor(Color.YELLOW)
                    mBinding.cvAnswer.setOnClickListener {
                        answer(mBinding.tvVar4.text.toString(), 4)
                    }
                }

                mBinding.cvNext.setOnClickListener { viewModel.nextQuestion() }
                mBinding.cvFinish.setOnClickListener {
                    viewModel.finish()
                }

            }
        }
    }

    private fun defaultColor() {
        mBinding.cvVar1.setCardBackgroundColor(Color.WHITE)
        mBinding.cvVar2.setCardBackgroundColor(Color.WHITE)
        mBinding.cvVar3.setCardBackgroundColor(Color.WHITE)
        mBinding.cvVar4.setCardBackgroundColor(Color.WHITE)
    }

    private fun blockedAnswer() {
        mBinding.cvVar1.isClickable = false
        mBinding.cvVar2.isClickable = false
        mBinding.cvVar3.isClickable = false
        mBinding.cvVar4.isClickable = false
        mBinding.cvNext.isClickable = false
        mBinding.cvFinish.isClickable = false
        mBinding.cvAnswer.isClickable = false
    }

    private fun openedAnswer() {
        mBinding.cvVar1.isClickable = false
        mBinding.cvVar2.isClickable = false
        mBinding.cvVar3.isClickable = false
        mBinding.cvVar4.isClickable = false
        mBinding.cvNext.isClickable = false
        mBinding.cvFinish.isClickable = false
        mBinding.cvAnswer.isClickable = false
    }

    private fun answer(answer: String, inputVar: Int) {

        blockedAnswer()

        when (inputVar) {
            1 -> mBinding.cvVar1.setCardBackgroundColor(Color.GRAY)
            2 -> mBinding.cvVar2.setCardBackgroundColor(Color.GRAY)
            3 -> mBinding.cvVar3.setCardBackgroundColor(Color.GRAY)
            4 -> mBinding.cvVar4.setCardBackgroundColor(Color.GRAY)
        }

        when (variant1) {
            mBinding.tvVar1.text -> mBinding.cvVar1.setCardBackgroundColor(Color.GREEN)
            mBinding.tvVar2.text -> mBinding.cvVar2.setCardBackgroundColor(Color.GREEN)
            mBinding.tvVar3.text -> mBinding.cvVar3.setCardBackgroundColor(Color.GREEN)
            mBinding.tvVar4.text -> mBinding.cvVar4.setCardBackgroundColor(Color.GREEN)
        }

        if (answer == variant1) viewModel.onRightAnswer()

        Handler().postDelayed({
            viewModel.nextQuestion()
        }, 2000)

    }

    private fun getShuffledQuestions(): ArrayList<Quizzes> {
        val shuffledQuestions = arrayListOf<Quizzes>()
        for (i in 0..10) {
            shuffledQuestions.add(quizList!![Random.nextInt(0, quizList!!.size)])
        }
        return shuffledQuestions
    }

    private fun generateVariant() {
        variant1 = quizzes[indexQuiz!!].rightAnswer
        variant2 = quizzes[indexQuiz!!].wrongAnswers[0]
        variant3 = quizzes[indexQuiz!!].wrongAnswers[1]
        variant4 = quizzes[indexQuiz!!].wrongAnswers[2]
    }

    private fun variantRandom() {
        when (Random.nextInt(0, 8)) {
            0 -> {
                mBinding.tvVar1.text = variant1
                mBinding.tvVar2.text = variant2
                mBinding.tvVar3.text = variant3
                mBinding.tvVar4.text = variant4
            }
            1 -> {
                mBinding.tvVar1.text = variant4
                mBinding.tvVar2.text = variant1
                mBinding.tvVar3.text = variant2
                mBinding.tvVar4.text = variant3

            }
            2 -> {
                mBinding.tvVar1.text = variant3
                mBinding.tvVar2.text = variant4
                mBinding.tvVar3.text = variant1
                mBinding.tvVar4.text = variant2
            }
            3 -> {
                mBinding.tvVar1.text = variant2
                mBinding.tvVar2.text = variant3
                mBinding.tvVar3.text = variant4
                mBinding.tvVar4.text = variant1
            }
            4 -> {
                mBinding.tvVar1.text = variant3
                mBinding.tvVar2.text = variant1
                mBinding.tvVar3.text = variant2
                mBinding.tvVar4.text = variant4
            }
            5 -> {
                mBinding.tvVar1.text = variant4
                mBinding.tvVar2.text = variant2
                mBinding.tvVar3.text = variant1
                mBinding.tvVar4.text = variant3
            }
            6 -> {
                mBinding.tvVar1.text = variant3
                mBinding.tvVar2.text = variant2
                mBinding.tvVar3.text = variant1
                mBinding.tvVar4.text = variant4
            }
            7 -> {
                mBinding.tvVar1.text = variant2
                mBinding.tvVar2.text = variant4
                mBinding.tvVar3.text = variant3
                mBinding.tvVar4.text = variant1
            }
            8 -> {
                mBinding.tvVar1.text = variant1
                mBinding.tvVar2.text = variant3
                mBinding.tvVar3.text = variant4
                mBinding.tvVar4.text = variant2
            }
        }
    }
}
