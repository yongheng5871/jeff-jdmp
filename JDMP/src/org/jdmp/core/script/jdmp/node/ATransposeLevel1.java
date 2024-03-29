/* This file was generated by SableCC (http://www.sablecc.org/). */

package org.jdmp.core.script.jdmp.node;

import org.jdmp.core.script.jdmp.analysis.*;

@SuppressWarnings("nls")
public final class ATransposeLevel1 extends PLevel1
{
    private PLevel0 _level0_;
    private TTranspose _transpose_;

    public ATransposeLevel1()
    {
        // Constructor
    }

    public ATransposeLevel1(
        @SuppressWarnings("hiding") PLevel0 _level0_,
        @SuppressWarnings("hiding") TTranspose _transpose_)
    {
        // Constructor
        setLevel0(_level0_);

        setTranspose(_transpose_);

    }

    @Override
    public Object clone()
    {
        return new ATransposeLevel1(
            cloneNode(this._level0_),
            cloneNode(this._transpose_));
    }

    public void apply(Switch sw)
    {
        ((Analysis) sw).caseATransposeLevel1(this);
    }

    public PLevel0 getLevel0()
    {
        return this._level0_;
    }

    public void setLevel0(PLevel0 node)
    {
        if(this._level0_ != null)
        {
            this._level0_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._level0_ = node;
    }

    public TTranspose getTranspose()
    {
        return this._transpose_;
    }

    public void setTranspose(TTranspose node)
    {
        if(this._transpose_ != null)
        {
            this._transpose_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._transpose_ = node;
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._level0_)
            + toString(this._transpose_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._level0_ == child)
        {
            this._level0_ = null;
            return;
        }

        if(this._transpose_ == child)
        {
            this._transpose_ = null;
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        if(this._level0_ == oldChild)
        {
            setLevel0((PLevel0) newChild);
            return;
        }

        if(this._transpose_ == oldChild)
        {
            setTranspose((TTranspose) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}
